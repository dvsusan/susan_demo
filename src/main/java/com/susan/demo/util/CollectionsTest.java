package com.susan.demo.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 主要介绍Collections类的常用方法
 *
 * @author sue
 * @date 2023/2/17 22:12
 */
public class CollectionsTest {

    /**
     * 实现升序和降序
     */
    @Test
    public void testSort() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        //升序
        Collections.sort(list);
        System.out.println(list);
        //降序
        Collections.reverse(list);
        System.out.println(list);
    }


    /**
     * 有时候需要找出集合中的最大值或者最小值
     */
    @Test
    public void testMaxAndMin() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        Integer max = Collections.max(list);//获取最大值
        Integer min = Collections.min(list);//获取最小值
        System.out.println(max);
        System.out.println(min);
    }

    /**
     * 我们都知道，java中的很多集合，比如：ArrayList、LinkedList、HashMap、HashSet等，都是线程不安全的。
     * <p>
     * 换句话说，这些集合在多线程的环境中，添加数据会出现异常。
     * <p>
     * 这时，可以用Collections的synchronizedxxx方法，将这些线程不安全的集合，直接转换成线程安全集合
     */
    @Test
    public void testSynchronized() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        //将ArrayList转换成线程安全集合
        List<Integer> integers = Collections.synchronizedList(list);
        System.out.println(integers);
    }

    /**
     * 有时，我们在判空之后，需要返回空集合，就可以使用emptyList方法
     */
    public List<Integer> fun(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return Collections.emptyList();
        }
        //业务处理
        return list;
    }

    /**
     * binarySearch方法提供了一个非常好用的二分查找功能，只用传入指定集合和需要找到的key即可
     */
    @Test
    public void testBinarySearch() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        int i = Collections.binarySearch(list, 3);
        System.out.println(i);
    }

    /**
     * 为了防止后续的程序把某个集合的结果修改了，有时候我们需要把某个集合定义成不可修改的，
     * 使用Collections的unmodifiablexxx方法就能轻松实现
     */
    @Test
    public void testUnmodifiable() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        List<Integer> integers = Collections.unmodifiableList(list);
        integers.add(4);
        System.out.println(integers);
    }
}
