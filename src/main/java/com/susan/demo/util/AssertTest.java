package com.susan.demo.util;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * 主要介绍Assert类的常用方法
 *
 * @author sue
 * @date 2023/2/17 23:05
 */
public class AssertTest {

    /**
     * 断言参数是否空，如果不满足条件，则直接抛异常
     */
    @Test
    public void testAssertNull() {
        String str = null;
        Assert.isNull(str, "str必须为空");
        Assert.isNull(str, () -> "str必须为空");
        Assert.notNull(str, "str不能为空");
    }

    /**
     * 断言集合是否空，如果不满足条件，则直接抛异常
     */
    @Test
    public void testAssertCollection() {
        List<String> list = null;
        Map<String, String> map = null;
        Assert.notEmpty(list, "list不能为空");
        Assert.notEmpty(list, () -> "list不能为空");
        Assert.notEmpty(map, "map不能为空");
    }

    /**
     * 断言是否满足某个条件，如果不满足条件，则直接抛异常
     */
    @Test
    public void testAssertCondition() {
        List<String> list = null;
        Assert.isTrue(CollectionUtils.isNotEmpty(list), "list不能为空");
        Assert.isTrue(CollectionUtils.isNotEmpty(list), () -> "list不能为空");
    }
}
