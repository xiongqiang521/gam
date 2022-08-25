package org.xq.gam.api.service;

import org.xq.gam.api.service.entity.ClientDTO;

/**
 * 客户端注册器
 *
 * @author xiognqiang
 * 2022/7/29 15:09
 */
public interface ClientRegister {

    public void register(ClientDTO client);

    public void remove(Long clientId);

    public void health(Long clientId);

}
