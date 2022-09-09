package org.xq.gam.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * jackson 配置类
 *
 * @author xiognqiang
 * 2022/8/25 11:35
 */
@Configuration
public class JacksonConfiguration {
    private static final String TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN);

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {

        return builder -> {
            builder.serializationInclusion(JsonInclude.Include.ALWAYS);
            builder.failOnEmptyBeans(false);
            builder.failOnUnknownProperties(false);

            builder.dateFormat(new SimpleDateFormat(TIME_PATTERN));
            builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(TIME_FORMATTER));
            builder.deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(TIME_FORMATTER));
        };
    }
}
