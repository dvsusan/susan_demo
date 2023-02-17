package com.susan.demo.util;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 主要介绍CollectionUtils工具类的常用方法
 *
 * @author sue
 * @date 2023/2/17 22:47
 */
public class CollectionUtilsTest {

    /**
     * 通过CollectionUtils工具类的isEmpty方法可以轻松判断集合是否为空，
     * isNotEmpty方法判断集合不为空。
     */
    @Test
    public void testEmpty() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        if (CollectionUtils.isEmpty(list)) {
            System.out.println("集合为空");
        }

        if (CollectionUtils.isNotEmpty(list)) {
            System.out.println("集合不为空");
        }
    }

    /**
     * 有时候我们需要对已有的两个集合进行操作，比如取交集或者并集等。
     */
    @Test
    public void testCompare() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);

        //获取并集
        Collection<Integer> unionList = CollectionUtils.union(list, list2);
        System.out.println(unionList);

        //获取交集
        Collection<Integer> intersectionList = CollectionUtils.intersection(list, list2);
        System.out.println(intersectionList);

        //获取交集的补集
        Collection<Integer> disjunctionList = CollectionUtils.disjunction(list, list2);
        System.out.println(disjunctionList);

        //获取差集
        Collection<Integer> subtractList = CollectionUtils.subtract(list, list2);
        System.out.println(subtractList);
    }
}
