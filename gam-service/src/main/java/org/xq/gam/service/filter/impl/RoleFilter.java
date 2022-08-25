package org.xq.gam.service.filter.impl;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import org.xq.gam.service.filter.GamFilter;
import reactor.core.publisher.Mono;

/**
 * 角色过滤器
 *
 * @author xiognqiang
 * 2022/8/24 15:54
 */
@Service
public class RoleFilter implements GamFilter {

    @Override
    public GatewayFilter get() {
        return new RoleFilter();
    }

    @Override
    public String describe() {
        return "角色过滤器";
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange);
    }

}
