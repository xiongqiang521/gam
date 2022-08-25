package org.xq.gam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;
import org.xq.gam.envet.ClientRemoteEvent;
import org.xq.gam.envet.RefreshRemoteRouteEvent;

/**
 * ${DESCRIPTION}
 *
 * @author xiongqiang
 * @version 1.0
 */
@SpringBootApplication()
@EnableRedisWebSession
@RemoteApplicationEventScan(basePackageClasses = {ClientRemoteEvent.class, RefreshRemoteRouteEvent.class})
public class GamApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GamApplication.class, args);
        System.out.println("========== GamApplication started =============");

    }
}