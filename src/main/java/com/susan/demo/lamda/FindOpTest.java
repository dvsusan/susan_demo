package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 查找操作，包含：findFirst、findAny
 * <p>
 * findFirst：找到第一个，返回的类型为Optional
 * <p>
 * findAny：使用 stream() 时找到的是第一个元素，使用 parallelStream() 并行时找到的是其中一个元素，返回的类型为Optional
 *
 * @author sue
 * @date 2023/2/16 18:44
 */

public class FindOpTest {

    @Test
    public void testFindOp() {
        List<String> list = Lists.newArrayList("a", "b", "ab", "abc", "bc", "ab");
        //查找第一匹配的元素
        String data1 = list.stream().findFirst().orElse(null);
        //结果: a
        System.out.println(data1);

        String data2 = list.stream().findAny().orElse(null);
        //结果: a
        System.out.println(data2);
    }
}