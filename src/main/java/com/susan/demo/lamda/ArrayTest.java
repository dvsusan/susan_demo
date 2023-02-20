package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 数组操作，将数据流的元素转换成数组。
 *
 * @author sue
 * @date 2023/2/16 18:51
 */
public class ArrayTest {

    @Test
    public void testArray() {
        List<String> list = Lists.newArrayList("a", "b", "ab");
        String[] strings = list.stream().toArray(String[]::new);
        //结果：a b ab
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + " ");
        }
    }
}
