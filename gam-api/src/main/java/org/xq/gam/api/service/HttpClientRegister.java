package org.xq.gam.api.service;

import org.xq.gam.api.service.entity.ClientDTO;

/**
 * 通过 HTTP 的方式注册到服务端
 *
 * @author xiognqiang
 * 2022/7/29 15:16
 */
public class HttpClientRegister implements ClientRegister {

    @Override
    public void register(ClientDTO client) {
        // http 的方式注册客户端
    }

    @Override
    public void remove(Long clientId) {

    }

    @Override
    public void health(Long clientId) {

    }
}
