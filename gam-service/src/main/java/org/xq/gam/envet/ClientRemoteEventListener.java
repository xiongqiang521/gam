package org.xq.gam.envet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * 客户端事件监听器
 *
 * @author xiognqiang
 * 2022/8/25 16:40
 */
@Service
public class ClientRemoteEventListener {
    private static final Logger logger = LoggerFactory.getLogger(ClientRemoteEventListener.class);

    @EventListener
    public void onEvent(ClientRemoteEvent event) {
        logger.info("event: {}", event.getClientDTO());
    }
}
