package org.xq.gam.convertor;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.xq.gam.entity.RouteDefinitionEntity;
import org.xq.gam.util.JsonUtil;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * Description: 类型转换器
 *
 * @author 13797
 * @version v0.0.1
 * @date 2021/10/4 10:48
 */
public class RouteConvertor {

    private static final TypeReference<List<PredicateDefinition>> PREDICATE_DEFINITION_LIST_TYPE
            = new TypeReference<List<PredicateDefinition>>() {
    };
    private static final TypeReference<List<FilterDefinition>> FILTER_DEFINITION_LIST_TYPE =
            new TypeReference<List<FilterDefinition>>() {
            };
    private static final TypeReference<Map<String, Object>> METADATA_MAP_TYPE =
            new TypeReference<Map<String, Object>>() {
            };

    public static RouteDefinition convertRouteDefinition(RouteDefinitionEntity entity) {
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId(entity.id());
        routeDefinition.setOrder(entity.order());
        routeDefinition.setUri(URI.create(entity.uri()));
        routeDefinition.setPredicates(JsonUtil.string2Obj(entity.predicates(),
                PREDICATE_DEFINITION_LIST_TYPE));
        routeDefinition.setFilters(
                JsonUtil.string2Obj(entity.filters(), FILTER_DEFINITION_LIST_TYPE));
        routeDefinition.setMetadata(JsonUtil.string2Obj(entity.metadata(), METADATA_MAP_TYPE));
        return routeDefinition;
    }

    public static RouteDefinitionEntity convertRouteDefinitionEntity(RouteDefinition routeDefinition) {
        return new RouteDefinitionEntity(
                routeDefinition.getId(),
                routeDefinition.getUri().toString(),
                JsonUtil.obj2String(routeDefinition.getPredicates()),
                JsonUtil.obj2String(routeDefinition.getFilters()),
                JsonUtil.obj2String(routeDefinition.getMetadata()),
                routeDefinition.getOrder()
        );

    }

}
