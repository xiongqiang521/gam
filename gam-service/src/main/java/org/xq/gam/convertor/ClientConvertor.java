package org.xq.gam.convertor;


import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.xq.gam.api.service.entity.ClientApiDTO;

import java.net.URI;

/**
 * ClientApiDTO 实体类转换器
 *
 * @author xiognqiang
 * 2022/7/29 18:59
 */
public class ClientConvertor {

    public static RouteDefinition convertRouteDefinition(ClientApiDTO clientApiDTO) {
        StringBuilder sb = new StringBuilder();
        sb.append(clientApiDTO.getService()).append(":")
                .append(clientApiDTO.getMethod()).append(":")
                .append(clientApiDTO.getName());
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId(sb.toString());
        routeDefinition.setUri(URI.create(clientApiDTO.getServiceAddress()));

        // 添加 断言
        PredicateDefinition pathPredicate = new PredicateDefinition();
        pathPredicate.setName("Path");
        pathPredicate.addArg("paths", clientApiDTO.getPath());

        PredicateDefinition methodPredicate = new PredicateDefinition();
        methodPredicate.setName("Method");
        methodPredicate.addArg("methods", clientApiDTO.getMethod());

        routeDefinition.getPredicates().add(pathPredicate);
        routeDefinition.getPredicates().add(methodPredicate);

        return routeDefinition;
    }

}
