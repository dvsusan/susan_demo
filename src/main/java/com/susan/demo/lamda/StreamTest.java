package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * stream：是单管道，称其为流，其主要用于集合的逻辑处理。
 *
 * @author sue
 * @date 2023/2/16 18:52
 */

public class StreamTest {

    @Test
    public void testStream() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
        //结果：1234567
        list.stream().forEach(System.out::print);
    }
}
