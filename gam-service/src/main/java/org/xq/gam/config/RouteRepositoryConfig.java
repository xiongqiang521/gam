package org.xq.gam.config;

import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xq.gam.config.impl.R2dbcRouteDefinitionRepository;
import org.xq.gam.mapper.RouteDefinitionMapper;

/**
 * 路由序列化相关的配置
 *
 * @author xiognqiang
 * 2022/7/27 11:35
 */
@Configuration
public class RouteRepositoryConfig {

    /**
     * 使用mysql序列化的实现方式
     *
     * @return
     */
    @Bean
    public RouteDefinitionRepository repository(RouteDefinitionMapper mapper) {
        return new R2dbcRouteDefinitionRepository(mapper);
    }

}
