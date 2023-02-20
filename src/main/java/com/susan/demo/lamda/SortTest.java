package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 对元素进行排序，前提是实现Comparable接口，当然也可以自定义比较器。
 *
 * @author sue
 * @date 2023/2/16 18:39
 */

public class SortTest {

    @Test
    public void testSort() {
        List<Integer> list = Lists.newArrayList(5, 3, 7, 1, 4, 6);
        List<Integer> collect = list.stream().sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());
        //结果：[1, 3, 4, 5, 6, 7]
        System.out.println(collect);
    }
}
