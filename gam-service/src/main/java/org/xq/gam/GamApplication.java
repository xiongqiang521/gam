package org.xq.gam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;

/**
 * ${DESCRIPTION}
 *
 * @author xiongqiang
 * @version 1.0
 */
@SpringBootApplication()
@EnableRedisWebSession
public class GamApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GamApplication.class, args);
        System.out.println("========== GamApplication started =============");

    }
}