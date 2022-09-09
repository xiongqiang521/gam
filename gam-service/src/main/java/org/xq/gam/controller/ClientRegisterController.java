package org.xq.gam.controller;

import cn.hutool.core.collection.CollUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xq.gam.api.service.entity.ClientDTO;
import org.xq.gam.convertor.ClientConvertor;
import org.xq.gam.event.ClientRemoteEvent;
import org.xq.gam.service.predicate.PredicateFactoryHandler;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 客户端管理
 *
 * @author xiognqiang
 * 2022/7/29 15:18
 */
@RestController
@RequestMapping("/manager/client")
@RequiredArgsConstructor
public class ClientRegisterController {

    private static final Duration EXPORT_TIME = Duration.ofSeconds(60);

    private final ApplicationEventPublisher eventPublisher;
    private final RouteDefinitionRepository repository;
    private final ReactiveRedisTemplate<String, ClientDTO> redisOperations;

    private final PredicateFactoryHandler predicateFactoryHandler;

    @PostMapping("/{clientId}/api/{apiId}")
    public Mono<Void> serializeApi(
            @PathVariable("clientId") Long clientId,
            @PathVariable("apiId") String apiName,
            @RequestBody() Map<String, Map<String, String>> predicateMap
    ) {
        Mono<RouteDefinition> definitionMono = redisOperations.opsForValue().get(makeKey(clientId))
                .map(ClientDTO::getApis)
                .mapNotNull(apis -> apis.stream()
                        .filter(api -> Objects.equals(api.getName(), apiName))
                        .findFirst().orElse(null)
                )
                .map(ClientConvertor::convertRouteDefinition);

        predicateMap.forEach((key, params) -> {
            if (predicateFactoryHandler.check(key)) {
                PredicateDefinition definition = new PredicateDefinition();
                definition.setName(key);
                definition.setArgs(params);
                definitionMono.map(de -> {
                    de.getPredicates().add(definition);
                    return de;
                });
            }

        });

        return repository.save(definitionMono);
    }

    @GetMapping()
    public Mono<List<ClientDTO>> getClients() {

        return redisOperations.keys(makeKey("*"))
                .collectList()
                .filter(CollUtil::isNotEmpty)
                .flatMap(keys -> redisOperations.opsForValue().multiGet(keys));
    }

    @GetMapping("/{id}")
    public Mono<ClientDTO> getClient(@PathVariable("id") Long clientId) {
        return redisOperations.opsForValue().get(makeKey(clientId));
    }

    @PostMapping("")
    public Mono<Boolean> register(@RequestBody ClientDTO client) {
        return redisOperations.opsForValue()
                .set(makeKey(client.getUuid()), client, EXPORT_TIME)
                .doOnSuccess(b -> eventPublisher.publishEvent(new ClientRemoteEvent(client)));
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> remove(@PathVariable("id") Long clientId) {
        return redisOperations.opsForValue()
                .delete(makeKey(clientId));
    }

    @GetMapping("/health")
    public Mono<ClientDTO> health(Long clientId) {
        return redisOperations.opsForValue()
                .getAndExpire(makeKey(clientId), EXPORT_TIME);
    }

    private String makeKey(Object id) {
        return "client:online:" + String.valueOf(id);
    }
}
