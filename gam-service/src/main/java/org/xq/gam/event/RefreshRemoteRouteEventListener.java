package org.xq.gam.event;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

/**
 * 刷新gateway事件 监听服务
 *
 * @author xiognqiang
 * 2022/7/27 11:12
 */
@Service
@RequiredArgsConstructor
public class RefreshRemoteRouteEventListener {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final StreamBridge streamBridge;

    @EventListener
    public void onEvent(RefreshRemoteRouteEvent event) {
        // 推送MQ消息
        streamBridge.send("routeRefresh-out-0", new RefreshRoutesEvent(event));
    }

    /**
     * 接收MQ消息
     *
     * @return 处理函数
     */
    @Bean
    public Consumer<RefreshRoutesEvent> routeRefresh() {
        return applicationEventPublisher::publishEvent;
    }
}
