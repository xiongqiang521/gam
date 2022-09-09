package org.xq.gam.api.service.entity;


import java.io.Serial;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.List;

/**
 * 客户端
 */
public final class ClientDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;
    private Long uuid;
    private InetAddress ip;
    private String name;
    private String type;
    private String service;
    private String describe;
    private List<ClientApiDTO> apis;

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public InetAddress getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

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

    public List<ClientApiDTO> getApis() {
        return apis;
    }

    public void setApis(List<ClientApiDTO> apis) {
        this.apis = apis;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ClientDTO{");
        sb.append("uuid=").append(uuid);
        sb.append(", ip=").append(ip);
        sb.append(", name='").append(name).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", service='").append(service).append('\'');
        sb.append(", describe='").append(describe).append('\'');
        sb.append(", apis=").append(apis);
        sb.append('}');
        return sb.toString();
    }
}
