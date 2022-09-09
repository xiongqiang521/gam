package org.xq.gam.mapper;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.xq.gam.entity.RouteDefinitionEntity;

/**
 * RouteDefinitionEntity mapper
 * @author xiognqiang
 * 2022/7/27 11:42
 */
public interface RouteDefinitionMapper extends R2dbcRepository<RouteDefinitionEntity, String> {

}
