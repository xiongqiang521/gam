package org.xq.gam.config;

import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.xq.gam.config.impl.R2dbcRouteDefinitionRepository;
import org.xq.gam.mapper.RouteDefinitionMapper;

/**
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

    @Bean
    public ReactiveRedisTemplate<String, ?> reactiveRedisTemplate(
            ReactiveRedisConnectionFactory reactiveRedisConnectionFactory) {

        RedisSerializationContext<String, ?> serializationContext =
                RedisSerializationContext.<String, Object>newSerializationContext()
                        .key(StringRedisSerializer.UTF_8)
                        .value(RedisSerializer.json())
                        .hashKey(StringRedisSerializer.UTF_8)
                        .hashValue(RedisSerializer.json()).build();
        return new ReactiveRedisTemplate<>(reactiveRedisConnectionFactory, serializationContext);
    }

}
