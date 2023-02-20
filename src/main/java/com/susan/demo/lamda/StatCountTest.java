package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 指定一个字符串数组，找出里面相同的元素，并且统计重复的次数
 *
 * @author sue
 * @date 2023/2/16 18:31
 */
public class StatCountTest {

    @Test
    public void testStatCount() {
        List<String> list = Lists.newArrayList("a", "b", "ab", "abc", "a", "ab", "a", "abcd", "bd", "abc");
        Map<String, Long> countMap = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        countMap.forEach((key, value) -> System.out.println("key:" + key + " value:" + value));
    }
}
