package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

/**
 * min：获取最小值，返回Optional类型的数据
 * <p>
 * max：获取最大值，返回Optional类型的数据
 *
 * @author sue
 * @date 2023/2/16 18:45
 */

public class MaxMinTest {

    @Test
    public void testMaxMin() {
        List<Integer> list = Lists.newArrayList(2, 3, 5, 7);
        Optional<Integer> max = list.stream().max((a, b) -> a.compareTo(b));
        //结果：7
        System.out.println(max.get());

        Optional<Integer> min = list.stream().min((a, b) -> a.compareTo(b));
        //结果：2
        System.out.println(min.get());
    }
}
