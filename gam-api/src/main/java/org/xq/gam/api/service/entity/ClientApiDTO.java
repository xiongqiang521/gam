package org.xq.gam.api.service.entity;

import java.io.Serial;
import java.io.Serializable;

/**
 * 客户端服务api实体类
 */
public final class ClientApiDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;
    private String name;
    private String type;
    private String service;
    private String describe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "ClientApiDTO{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", service='" + service + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
