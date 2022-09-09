package org.xq.gam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;

/**
 * ${DESCRIPTION}
 *
 * @author xiongqiang
 * @version 1.0
 */
@SpringBootApplication()
@EnableRedisWebSession
@EnableAsync
public class GamApplication {
    private static final Logger logger = LoggerFactory.getLogger(GamApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GamApplication.class, args);
        logger.info("========== GamApplication started =============");
    }
}
