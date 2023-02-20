package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 从一个指定的字符串数组中，查找指定的字符串是否存在
 *
 * @author sue
 * @date 2023/2/16 18:33
 */
public class FindValueTest {

    @Test
    public void testFindValue() {
        String findStr = "bd";
        List<String> list = Lists.newArrayList("a", "b", "ab", "abc", "a", "ab", "a", "abcd", "bd", "abc");
        boolean match = list.stream().anyMatch(x -> x.equals(findStr));
        //结果：match:true
        System.out.println("match:" + match);
    }
}
