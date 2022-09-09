package org.xq.gam.service.predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;

import java.util.List;

/**
 * gam断言的配置类
 *
 * @param <C> 配置类
 * @author xiognqiang
 * 2022/8/24 17:04
 */
public abstract class GamAbstractRoutePredicateFactory<C> extends AbstractRoutePredicateFactory<C> {

    public GamAbstractRoutePredicateFactory(Class<C> configClass) {
        super(configClass);
    }

    @Override
    public String name() {
        return super.name();
    }

    /**
     * 配置的参数
     */
    public abstract List<Item> getItems();

    public static class Item {
        private final String name;
        private final Class<?> clazz;
        private final boolean required;
        private final String describe;

        public Item(String name, Class<?> clazz) {
            this(name, clazz, false);
        }

        public Item(String name, Class<?> clazz, boolean required) {
            this(name, clazz, required, null);
        }

        public Item(String name, Class<?> clazz, boolean required, String describe) {
            this.name = name;
            this.clazz = clazz;
            this.required = required;
            this.describe = describe;
        }

        public String getDescribe() {
            return describe;
        }

        public String getName() {
            return name;
        }

        public Class<?> getClazz() {
            return clazz;
        }

        public boolean isRequired() {
            return required;
        }
    }
}
