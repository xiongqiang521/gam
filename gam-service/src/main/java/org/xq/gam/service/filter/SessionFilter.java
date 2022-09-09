package org.xq.gam.service.filter;

import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.xq.gam.util.WebUtil;
import reactor.core.publisher.Mono;

/**
 * session 过滤器
 *
 * @author xiognqiang
 * 2022/8/24 17:33
 */
@Component
public class SessionFilter implements WebFilter, PriorityOrdered {

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        return chain.filter(exchange).contextWrite(context -> {
            exchange.getSession().subscribe(session -> context.put(WebUtil.WEB_SESSION_CLASS, session));
            context.put(WebUtil.REQUEST_CLASS, exchange.getRequest());
            context.put(WebUtil.RESPONSE_CLASS, exchange.getResponse());
            return context;
        });
    }
}
