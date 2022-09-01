package org.xq.gam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author xiognqiang
 * 2022/8/30 16:49
 */
@Configuration
public class RedisConfig {
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
