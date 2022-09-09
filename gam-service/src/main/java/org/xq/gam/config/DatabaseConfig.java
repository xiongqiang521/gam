package org.xq.gam.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 数据库配置
 *
 * @author xiognqiang
 * 2022/8/30 16:45
 */
@Configuration
@EnableConfigurationProperties(FlywayProperties.class)
public class DatabaseConfig {

    /**
     * flyway 配置
     *
     * @param r2dbcProperties
     * @param flywayProperties
     * @return
     * @see FlywayAutoConfiguration.FlywayConfiguration#flyway
     * @see FlywayAutoConfiguration.FlywayConfiguration#configureProperties
     */
    @Bean(initMethod = "migrate")
    public Flyway flyway(R2dbcProperties r2dbcProperties, FlywayProperties flywayProperties) {

        String r2dbcUrl = r2dbcProperties.getUrl();
        String username = r2dbcProperties.getUsername();
        String password = r2dbcProperties.getPassword();

        // r2dbc 连接地址替换为 jdbc连接地址
        String jdbcUrl = r2dbcUrl.replace("r2dbc", "jdbc");

        return new Flyway(Flyway.configure()
                .baselineOnMigrate(flywayProperties.isBaselineOnMigrate())
                .dataSource(jdbcUrl, username, password)
        );
    }
}
