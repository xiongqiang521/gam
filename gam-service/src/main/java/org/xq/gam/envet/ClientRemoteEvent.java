package org.xq.gam.envet;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;
import org.xq.gam.api.service.entity.ClientDTO;

/**
 * 客户端远程事件
 *
 * @author xiognqiang
 * 2022/8/25 16:30
 */
public class ClientRemoteEvent extends RemoteApplicationEvent {

    private final ClientDTO clientDTO;

    public ClientRemoteEvent(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }
}
