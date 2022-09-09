package org.xq.gam.service;

import org.springframework.core.Ordered;

import javax.validation.ValidationException;

/**
 * 校验器接口
 *
 * @param <E> 待校验的数据实体
 * @author xiognqiang
 * 2022/8/22 14:11
 */
@FunctionalInterface
public interface Checker<E> extends Ordered {

    default boolean enable(E data) {
        return true;
    }

    @Override
    default int getOrder() {
        return 1;
    }

    public void check(E data) throws ValidationException;

}
