package org.xq.gam.service.predicate;

import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * 角色断言
 *
 * @author xiognqiang
 * 2022/8/24 16:15
 */
@Component
public class DomainRoutePredicateFactory extends GamAbstractRoutePredicateFactory<DomainRoutePredicateFactory.Config> {

    private final List<Item> items = new ArrayList<>();

    public DomainRoutePredicateFactory() {
        super(Config.class);
        items.add(new Item("domainId", Long.class, true));
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {

        return new GatewayPredicate() {
            @Override
            public Object getConfig() {
                return config;
            }

            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                Long domainId = serverWebExchange.getAttribute("domainId");
                return Objects.equals(domainId, config.getDomainId());
            }
        };
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    public static class Config {
        private Long domainId;

        public Long getDomainId() {
            return domainId;
        }

        public void setDomainId(Long domainId) {
            this.domainId = domainId;
        }

    }

}
