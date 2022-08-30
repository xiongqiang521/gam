package org.xq.gam.event;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.xq.gam.api.service.entity.ClientDTO;

import java.util.function.Consumer;

/**
 * 客户端事件监听器
 *
 * @author xiognqiang
 * 2022/8/25 16:40
 */
@Service
@RequiredArgsConstructor
public class ClientRemoteEventListener {
    private static final Logger logger = LoggerFactory.getLogger(ClientRemoteEventListener.class);

    private final StreamBridge streamBridge;

    @EventListener
    public void onEvent(ClientRemoteEvent event) {
        streamBridge.send("consumerClient-out-0", event.getClientDTO());
        logger.info("event: {}", event.getClientDTO());
    }

    @Bean
    public Consumer<ClientDTO> consumerClient() {
        return clientDTO -> {
            logger.info("consumerClient: {}", clientDTO);
        };
    }


}
