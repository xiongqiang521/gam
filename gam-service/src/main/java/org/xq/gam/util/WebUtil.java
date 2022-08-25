package org.xq.gam.util;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

/**
 * web工具类
 *
 * @author xiognqiang
 * 2022/7/29 16:12
 */
public class WebUtil {

    public static final Class<WebSession> WEB_SESSION_CLASS = WebSession.class;
    public static final Class<ServerHttpRequest> REQUEST_CLASS = ServerHttpRequest.class;
    public static final Class<ServerHttpResponse> RESPONSE_CLASS = ServerHttpResponse.class;

    public Mono<WebSession> getSession() {
        return Mono.deferContextual(contextView -> Mono.justOrEmpty(contextView.get(WEB_SESSION_CLASS)));
    }

    public Mono<ServerHttpRequest> getRequest() {
        return Mono.deferContextual(contextView -> Mono.justOrEmpty(contextView.get(REQUEST_CLASS)));
    }

    public Mono<ServerHttpResponse> getResponse() {
        return Mono.deferContextual(contextView -> Mono.justOrEmpty(contextView.get(RESPONSE_CLASS)));
    }

}
