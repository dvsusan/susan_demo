package com.susan.demo.util;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 主要介绍StringUtils类中常用的方法
 *
 * @author sue
 * @date 2023/2/17 23:02
 */
public class StringUtilsTest {

    /**
     * 其实空字符串，不只是null一种，还有""，" "，"null"等等，多种情况。
     * <p>
     * StringUtils给我们提供了多个判空的静态方法
     */
    @Test
    public void testEmpty() {
        String str1 = null;
        String str2 = "";
        String str3 = " ";
        String str4 = "abc";
        System.out.println(StringUtils.isEmpty(str1));
        System.out.println(StringUtils.isEmpty(str2));
        System.out.println(StringUtils.isEmpty(str3));
        System.out.println(StringUtils.isEmpty(str4));
        System.out.println("=====");
        System.out.println(StringUtils.isNotEmpty(str1));
        System.out.println(StringUtils.isNotEmpty(str2));
        System.out.println(StringUtils.isNotEmpty(str3));
        System.out.println(StringUtils.isNotEmpty(str4));
        System.out.println("=====");
        System.out.println(StringUtils.isBlank(str1));
        System.out.println(StringUtils.isBlank(str2));
        System.out.println(StringUtils.isBlank(str3));
        System.out.println(StringUtils.isBlank(str4));
        System.out.println("=====");
        System.out.println(StringUtils.isNotBlank(str1));
        System.out.println(StringUtils.isNotBlank(str2));
        System.out.println(StringUtils.isNotBlank(str3));
        System.out.println(StringUtils.isNotBlank(str4));
    }

    /**
     * 分隔字符串是常见需求，如果直接使用String类的split方法，就可能会出现空指针异常
     */
    @Test
    public void testSplit() {
        String str1 = null;
        System.out.println(StringUtils.split(str1, ","));
        System.out.println(str1.split(","));
    }

    /**
     * 给定一个字符串，判断它是否为纯数字，
     * 可以使用isNumeric方法
     */
    @Test
    public void testIsNumber() {
        String str1 = "123";
        String str2 = "123q";
        String str3 = "0.33";
        System.out.println(StringUtils.isNumeric(str1));
        System.out.println(StringUtils.isNumeric(str2));
        System.out.println(StringUtils.isNumeric(str3));
    }

    /**
     * 有时候，我们需要将某个集合的内容，拼接成一个字符串，然后输出，
     * 这时可以使用join方法
     */
    @Test
    public void testJoin() {
        List<String> list = Lists.newArrayList("a", "b", "c");
        List<Integer> list2 = Lists.newArrayList(1, 2, 3);
        System.out.println(StringUtils.join(list, ","));
        System.out.println(StringUtils.join(list2, " "));
    }
}
