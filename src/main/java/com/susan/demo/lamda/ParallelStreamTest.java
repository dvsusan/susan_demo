package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * parallelStream：是多管道，提供了流的并行处理，它是Stream的另一重要特性，其底层使用Fork/Join框架实现
 *
 * @author sue
 * @date 2023/2/16 18:52
 */
public class ParallelStreamTest {

    @Test
    public void testParallelStream() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
        //结果：5726134
        list.parallelStream().forEach(System.out::print);
    }
}
