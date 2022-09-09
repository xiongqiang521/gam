package org.xq.gam.api.domain;

/**
 * 租户实体类
 *
 * @param id
 * @param name
 * @param type
 * @param describe
 *
 * @author xiongqiang
 */
public record DomainEntity(
        Long id,
        String name,
        String type,
        String describe
) {
}
