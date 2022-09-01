package org.xq.gam.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.context.ApplicationEvent;
import org.xq.gam.api.service.entity.ClientDTO;

/**
 * 客户端远程事件
 *
 * @author xiognqiang
 * 2022/8/25 16:30
 */
public class ClientRemoteEvent extends ApplicationEvent {
    private static final Object TRANSIENT_SOURCE = new Object();

    private final ClientDTO clientDTO;

    @JsonCreator
    public ClientRemoteEvent(ClientDTO clientDTO) {
        super(TRANSIENT_SOURCE);
        this.clientDTO = clientDTO;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }
}
