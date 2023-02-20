package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 将字符串集合转换成其他类型的集合
 *
 * @author sue
 * @date 2023/2/16 18:36
 */
public class TypeConvertTest {

    @Test
    public void testMap() {
        List<String> list = Lists.newArrayList("1", "2", "3", "4", "5", "6");
        List<Long> collect1 = list.stream().map(Long::parseLong).collect(Collectors.toList());
        //结果：[1, 2, 3, 4, 5, 6]
        System.out.println(collect1);

        //结果：111111
        list.stream().mapToInt(x -> x.length()).forEach(System.out::print);
        System.out.println("");

        //结果：111111
        list.stream().mapToLong(x -> x.length()).forEach(System.out::print);
        System.out.println("");

        //结果：1.01.01.01.01.01.0
        list.stream().mapToDouble(x -> x.length()).forEach(System.out::print);
    }
}
