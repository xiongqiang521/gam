package org.xq.gam.service.predicate;

import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * gam断言的配置类
 *
 * @author xiognqiang
 * 2022/8/24 17:04
 */
@Validated
public class GamPredicateConfig {

    private List<Long> ids;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
