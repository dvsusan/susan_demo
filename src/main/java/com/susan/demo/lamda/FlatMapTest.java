package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 将流中的每一个元素 T 映射为一个流，再把每一个流连接成为一个流
 * <p>
 * 说直白点就是可以将集合中套集合的数据，合并到一个大集合
 *
 * @author sue
 * @date 2023/2/16 18:37
 */

public class FlatMapTest {

    @Test
    public void testFlatMap() {
        List<List<String>> list = new ArrayList<List<String>>() {{
            add(Lists.newArrayList("a", "b", "c"));
            add(Lists.newArrayList("d", "e", "f"));
            add(Lists.newArrayList("j", "k", "y"));
        }};
        //结果：[[a, b, c], [d, e, f], [j, k, y]]
        System.out.println(list);
        List<String> collect = list.stream().flatMap(List::stream).collect(Collectors.toList());
        //结果：[a, b, c, d, e, f, j, k, y]
        System.out.println(collect);
    }
}