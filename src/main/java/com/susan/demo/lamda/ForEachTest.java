package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 遍历操作，包含：forEach 和 forEachOrdered
 * <p>
 * forEach：支持并行处理
 * <p>
 * forEachOrdered：是按顺序处理的，遍历速度较慢
 *
 * @author sue
 * @date 2023/2/16 18:42
 */

public class ForEachTest {

    @Test
    public void testForEach() {
        List<String> list = Lists.newArrayList("a", "b", "ab");
        //结果：a b ab
        list.stream().forEach(x -> System.out.print(x + ' '));
        System.out.println("");

        //可以简化
        //结果：a b ab
        list.forEach(x -> System.out.print(x + ' '));
        System.out.println("");

        //结果：a b ab
        list.stream().forEachOrdered(x -> System.out.print(x + ' '));
    }
}
