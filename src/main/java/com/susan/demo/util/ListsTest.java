package com.susan.demo.util;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 主要介绍google的guava包下的Lists类的常用方法
 *
 * @author sue
 * @date 2023/2/17 22:49
 */
public class ListsTest {

    /**
     * 有时候，我们想创建一个空集合。这时可以用Lists的newArrayList方法
     */
    @Test
    public void testCreateEmptyList() {
        List<Integer> list = Lists.newArrayList();
    }

    /**
     * 有时候，我们想给一个集合中初始化一些元素。
     * 这时可以用Lists的newArrayList方法
     */
    @Test
    public void testInit() {
        List<Integer> list = Lists.newArrayList(1, 2, 3);
    }

    /**
     * 如果你想将两个集合做笛卡尔积，
     * Lists的cartesianProduct方法可以帮你实现
     */
    @Test
    public void testCartesian() {
        List<Integer> list1 = Lists.newArrayList(1, 2, 3);
        List<Integer> list2 = Lists.newArrayList(4, 5);
        List<List<Integer>> productList = Lists.cartesianProduct(list1, list2);
        System.out.println(productList);
    }

    /**
     * 如果你想将一个大集合分成若干个小集合，
     * 可以使用Lists的partition方法
     */
    @Test
    public void testPartition() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
        List<List<Integer>> partitionList = Lists.partition(list, 2);
        System.out.println(partitionList);
    }

    /**
     * 如果我们想把某个集合转换成另外一个接口，
     * 可以使用Lists的transform方法
     */
    @Test
    public void testTransform() {
        List<String> list = Lists.newArrayList("a", "b", "c");
        List<String> transformList = Lists.transform(list, x -> x.toUpperCase());
        System.out.println(transformList);
    }

    /**
     * Lists的有颠倒顺序的方法reverse
     */
    @Test
    public void testReverse() {
        List<Integer> list = Lists.newArrayList(3, 1, 2);
        List<Integer> reverseList = Lists.reverse(list);
        System.out.println(reverseList);
    }
}
