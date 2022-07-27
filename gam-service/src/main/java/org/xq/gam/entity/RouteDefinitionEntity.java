package org.xq.gam.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * 路由规则实体类
 *
 * @author xiognqiang
 * 2022/7/27 10:46
 */
@Table("t_route_definition")
public record RouteDefinitionEntity(
        @Id String id,
        String uri,
        String predicates,
        String filters,
        String metadata,
        int order
) {

}
