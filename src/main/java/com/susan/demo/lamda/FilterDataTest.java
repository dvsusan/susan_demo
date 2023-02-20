package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 从指定集合中根据某个条件过滤数据
 *
 * @author sue
 * @date 2023/2/16 18:34
 */
public class FilterDataTest {

    @Test
    public void testFilter() {
        List<Integer> list = Lists.newArrayList(20, 23, 25, 28, 30, 33, 37, 40);
        //从指定数据集合中过滤出大于等于30的数据集合
        List<Integer> collect = list.stream().filter(x -> x >= 30).collect(Collectors.toList());
        //结果：[33, 37, 40]
        System.out.println(collect);
    }
}
