package org.xq.gam.envet;

import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * 刷新gateway事件 监听服务
 *
 * @author xiognqiang
 * 2022/7/27 11:12
 */
@Service
public class RefreshRemoteRouteEventListener implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @EventListener
    public void onEvent(RefreshRemoteRouteEvent event) {
        applicationEventPublisher.publishEvent(new RefreshRoutesEvent(event));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
