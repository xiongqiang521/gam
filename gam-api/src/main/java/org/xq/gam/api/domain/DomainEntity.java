package org.xq.gam.api.domain;

/**
 * 租户实体类
 *
 * @author xiognqiang
 * 2022/7/26 18:16
 */
public record DomainEntity(
        Long id,
        String name,
        String type,
        String describe
) {
}
