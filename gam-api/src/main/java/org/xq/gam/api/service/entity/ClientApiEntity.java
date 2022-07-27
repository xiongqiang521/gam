package org.xq.gam.api.service.entity;

/**
 * 客户端服务api实体类
 *
 * @author xiognqiang
 */
public record ClientApiEntity(
        Long id,
        String name,
        String type,
        String describe
) {
}
