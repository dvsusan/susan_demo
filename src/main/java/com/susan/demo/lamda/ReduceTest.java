package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

/**
 * 规约操作，将整个数据流的值规约为一个值，count、min、max底层就是使用reduce。
 * <p>
 * reduce 操作可以实现从Stream中生成一个值，其生成的值不是随意的，而是根据指定的计算模型。
 *
 * @author sue
 * @date 2023/2/16 18:50
 */
public class ReduceTest {

    @Test
    public void testReduce() {
        List<Integer> list = Lists.newArrayList(2, 3, 5, 7);
        Integer sum1 = list.stream().reduce(0, Integer::sum);
        //结果：17
        System.out.println(sum1);

        Optional<Integer> reduce = list.stream().reduce((a, b) -> a + b);
        //结果：17
        System.out.println(reduce.get());

        Integer max = list.stream().reduce(0, Integer::max);
        //结果：7
        System.out.println(max);

        Integer min = list.stream().reduce(0, Integer::min);
        //结果：0
        System.out.println(min);


        Optional<Integer> reduce1 = list.stream().reduce((a, b) -> a > b ? b : a);
        //2
        System.out.println(reduce1.get());
    }
}
