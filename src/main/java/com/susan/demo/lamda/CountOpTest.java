package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 统计操作，效果跟调用集合的size()方法类似
 *
 * @author sue
 * @date 2023/2/16 18:45
 */

public class CountOpTest {

    @Test
    public void testCountOp() {
        List<String> list = Lists.newArrayList("a", "b", "ab");
        long count = list.stream().count();
        //结果：3
        System.out.println(count);
    }
}