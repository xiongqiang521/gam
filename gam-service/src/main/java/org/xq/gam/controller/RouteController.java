package org.xq.gam.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xq.gam.envet.RefreshRemoteRouteEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 路由控制类
 *
 * @author xiognqiang
 * 2022/7/26 18:23
 */
@RestController
@RequestMapping("/route/definition")
@RequiredArgsConstructor
public class RouteController {

    private final RouteDefinitionRepository routeDefinitionRepository;
    private final ApplicationEventPublisher eventPublisher;

    @GetMapping("/")
    public Flux<RouteDefinition> getRouteDefinitionList() {
        return routeDefinitionRepository.getRouteDefinitions();
    }

    /**
     * 将 routeDefinition 推送到gateway路由中
     * RouteDefinition -> Route
     *
     * @return
     */
    @PatchMapping("/refresh")
    public Mono<Void> refresh() {
        eventPublisher.publishEvent(new RefreshRemoteRouteEvent());
        return Mono.empty();
    }

}
