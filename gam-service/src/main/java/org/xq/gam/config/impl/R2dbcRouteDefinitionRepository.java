package org.xq.gam.config.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.xq.gam.convertor.RouteConvertor;
import org.xq.gam.mapper.RouteDefinitionMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * RouteDefinition 保存到数据库实现类
 *
 * @author xiognqiang
 * 2022/7/27 14:26
 */
@RequiredArgsConstructor
public class R2dbcRouteDefinitionRepository implements RouteDefinitionRepository {
    private final RouteDefinitionMapper mapper;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        return mapper.findAll().map(RouteConvertor::convertRouteDefinition);
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return route
                .map(RouteConvertor::convertRouteDefinitionEntity)
                .flatMap(mapper::save)
                .then();
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return routeId.flatMap(mapper::deleteById);
    }
}
