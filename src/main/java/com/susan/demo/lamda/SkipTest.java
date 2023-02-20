package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 跳过操作，比如：有个10个元素，从第5个元素开始去后面的元素
 *
 * @author sue
 * @date 2023/2/16 18:41
 */
public class SkipTest {

    @Test
    public void testSkip() {
        List<String> list = Lists.newArrayList("a", "b", "ab", "abc", "a", "ab", "a", "abcd", "bd", "abc");
        List<String> collect = list.stream().skip(5).collect(Collectors.toList());
        //结果：[ab, a, abcd, bd, abc]
        System.out.println(collect);
    }
}