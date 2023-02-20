package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 匹配操作，包含：allMatch、anyMatch、noneMatch
 * <p>
 * allMatch：所有元素都满足条件，返回boolean类型
 * <p>
 * anyMatch：任意一个元素满足条件，返回boolean类型
 * <p>
 * noneMatch：所有元素都不满足条件，返回boolean类型
 *
 * @author sue
 * @date 2023/2/16 18:44
 */
public class MatchTest {

    @Test
    public void testMatch() {
        List<Integer> list = Lists.newArrayList(2, 3, 5, 7);
        boolean allMatch = list.stream().allMatch(x -> x > 1);
        //结果：true
        System.out.println(allMatch);

        boolean allMatch2 = list.stream().allMatch(x -> x > 2);
        //结果：false
        System.out.println(allMatch2);

        boolean anyMatch = list.stream().anyMatch(x -> x > 2);
        //结果：true
        System.out.println(anyMatch);

        boolean noneMatch1 = list.stream().noneMatch(x -> x > 5);
        //结果：false
        System.out.println(noneMatch1);

        boolean noneMatch2 = list.stream().noneMatch(x -> x > 7);
        //结果：true
        System.out.println(noneMatch2);
    }
}
