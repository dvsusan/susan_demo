package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 去重，类似于msql中的distinct的作用，底层使用了equals方法做比较。
 *
 * @author sue
 * @date 2023/2/16 18:39
 */

public class DistinctTest {

    @Test
    public void testDistinct() {
        List<String> list = Lists.newArrayList("a", "b", "ab", "abc", "a", "ab", "a", "abcd", "bd", "abc");
        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        //结果：[a, b, ab, abc, abcd, bd]
        System.out.println(collect);
    }
}