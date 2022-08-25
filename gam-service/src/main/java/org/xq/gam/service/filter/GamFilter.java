package org.xq.gam.service.filter;

import org.springframework.beans.factory.NamedBean;
import org.springframework.cloud.gateway.filter.GatewayFilter;

import java.util.function.Supplier;

/**
 * gam服务自定义过滤器
 *
 * @author xiognqiang
 * 2022/8/24 16:03
 */
public interface GamFilter extends NamedBean, GatewayFilter, Supplier<GatewayFilter> {

    @Override
    default String getBeanName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 过滤器的描述信息
     *
     * @return 描述信息
     */
    String describe();

}
