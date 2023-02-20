package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 限流操作，有点类似于mysql中的limit功能，比如：有10个元素，只取前面3个元素
 *
 * @author sue
 * @date 2023/2/16 18:40
 */

public class LimitTest {

    @Test
    public void testLimit() {
        List<String> list = Lists.newArrayList("a", "b", "ab", "abc", "a", "ab", "a", "abcd", "bd", "abc");
        List<String> collect = list.stream().limit(3).collect(Collectors.toList());
        //结果：[a, b, ab]
        System.out.println(collect);
    }
}
