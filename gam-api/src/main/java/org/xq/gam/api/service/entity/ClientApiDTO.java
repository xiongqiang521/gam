package org.xq.gam.api.service.entity;

import java.io.Serial;
import java.io.Serializable;

/**
 * 客户端服务api实体类
 */
public final class ClientApiDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;
    /**
     * API接口名称
     */
    private String name;
    /**
     * API接口路径
     */
    private String path;
    /**
     * api接口 请求方法
     */
    private String method;
    /**
     * 对应服务名称
     */
    private String service;
    /**
     * 对应服务地址
     */
    private String serviceAddress;
    /**
     * api接口说明
     */
    private String describe;

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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
        final StringBuilder sb = new StringBuilder("ClientApiDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", path='").append(path).append('\'');
        sb.append(", method='").append(method).append('\'');
        sb.append(", service='").append(service).append('\'');
        sb.append(", serviceAddress='").append(serviceAddress).append('\'');
        sb.append(", describe='").append(describe).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
