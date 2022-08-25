package org.xq.gam.service.predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 角色断言
 *
 * @author xiognqiang
 * 2022/8/24 16:15
 */
@Component
public class DomainRoutePredicateFactory extends AbstractRoutePredicateFactory<GamPredicateConfig> {

    public DomainRoutePredicateFactory() {
        super(GamPredicateConfig.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(GamPredicateConfig config) {

        final List<Long> domainIdList = new ArrayList<>(config.getIds());

        return new GatewayPredicate() {
            @Override
            public Object getConfig() {
                return config;
            }

            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                Long domainId = serverWebExchange.getAttribute("domainId");
                return domainIdList.contains(domainId);
            }
        };

    }

}
