package org.xq.gam.service.predicate;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * gam自定义断言工具
 *
 * @author xiongqiang
 * @version 1.0
 * @description gam自定义断言工具
 * @projectName gam
 * @package org.xq.gam.service.predicate
 * @className PredicateFactoryHandler
 * @date 2022/9/7 下午6:38
 * @copyright 2021 www.cloudbooster.com Inc. All rights reserved.
 * @ 注意：本内容仅限于云加速(北京)科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Service
public class PredicateFactoryHandler {

    private final List<GamAbstractRoutePredicateFactory<?>> predicateFactories;
    private final Map<String, GamAbstractRoutePredicateFactory<?>> predicateFactoryMap;

    public PredicateFactoryHandler(List<GamAbstractRoutePredicateFactory<?>> predicateFactories) {
        this.predicateFactories = predicateFactories;
        this.predicateFactoryMap = predicateFactories.stream()
                .collect(Collectors.toMap(GamAbstractRoutePredicateFactory::name, Function.identity()));
    }

    public Map<String, GamAbstractRoutePredicateFactory<?>> names() {
        return predicateFactoryMap;
    }

    public boolean check(String name) {
        return predicateFactoryMap.containsKey(name);
    }

    public GamAbstractRoutePredicateFactory<?> get(String name) {
        return predicateFactoryMap.get(name);
    }

}
