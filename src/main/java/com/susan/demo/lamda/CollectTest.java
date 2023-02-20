package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.sun.tools.internal.xjc.reader.Ring.add;

/**
 * 收集操作，将所有的元素收集起来，Collectors 提供了非常多收集器。包含：toMap、toSet、toList、joining，groupingBy，maxBy，minBy等操作。
 * <p>
 * toMap：将数据流转换为map，里面包含的元素是用key/value的形式的
 * <p>
 * toSet：将数据流转换为set，里面包含的元素不可重复
 * <p>
 * toList：将数据流转出为list，里面包含的元素是有序的
 * <p>
 * joining：拼接字符串
 * <p>
 * groupingBy：分组，可以将list转换map
 * <p>
 * couting：统计元素数量
 * <p>
 * maxBy：获取最大元素
 * <p>
 * minBy：获取最小元素
 * <p>
 * summarizingInt: 汇总int类型的元素，返回IntSummaryStatistics，再调用具体的方法对元素进行统计：getCount（统计数量），getSum（求和），getMin（获取最小值），getMax（获取最大值），getAverage（获取平均值）
 * <p>
 * summarizingLong：汇总long类型的元素，用法同summarizingInt
 * <p>
 * summarizingDouble：汇总double类型的元素，用法同summarizingInt
 * <p>
 * averagingInt：获取int类型的元素的平均值，返回一个double类型的数据
 * <p>
 * averagingLong：获取long类型的元素的平均值，用法同averagingInt
 * <p>
 * averagingDouble：获取double类型的元素的平均值，用法同averagingInt
 * <p>
 * mapping：获取映射，可以将原始元素的一部分内容作为一个新元素返回
 *
 * @author sue
 * @date 2023/2/16 18:42
 */

public class CollectTest {

    @Data
    @AllArgsConstructor
    class User {
        private String name;
        private Integer age;
    }

    @Test
    public void testCollect() {
        List<String> list0 = Lists.newArrayList("a", "b", "ab");
        Map<String, String> collect0 = list0.stream().collect(Collectors.toMap(String::new, Function.identity()));
        //结果：{ab=ab, a=a, b=b}
        System.out.println(collect0);

        List<String> list = Lists.newArrayList("a", "b", "ab", "a", "b", "ab");
        List<String> collect1 = list.stream().collect(Collectors.toList());
        //结果：[a, b, ab, a, b, ab]
        System.out.println(collect1);

        //结果：[a, ab, b]
        Set<String> collect2 = list.stream().collect(Collectors.toSet());
        System.out.println(collect2);

        String collect3 = list.stream().collect(Collectors.joining(","));
        //结果：a,b,ab,a,b,ab
        System.out.println(collect3);

        Map<String, List<String>> collect4 = list.stream().collect(Collectors.groupingBy(Function.identity()));
        //结果：{ab=[ab, ab], a=[a, a], b=[b, b]}
        System.out.println(collect4);

        Long collect = list.stream().collect(Collectors.counting());
        //结果：6
        System.out.println(collect);

        String collect5 = list.stream().collect(Collectors.maxBy((a, b) -> a.compareTo(b))).orElse(null);
        //结果：b
        System.out.println(collect5);

        String collect6 = list.stream().collect(Collectors.minBy((a, b) -> a.compareTo(b))).orElse(null);
        //结果：a
        System.out.println(collect6);

        List<String> list2 = Lists.newArrayList("2", "3", "5");
        IntSummaryStatistics summaryStatistics = list2.stream().collect(Collectors.summarizingInt(x -> Integer.parseInt(x)));
        long sum = summaryStatistics.getSum();
        //结果：10
        System.out.println(sum);

        Double collect7 = list2.stream().collect(Collectors.averagingInt(x -> Integer.parseInt(x)));
        //结果：3.3333333333333335
        System.out.println(collect7);

        List<User> userList = new ArrayList<User>() {{
            add(new User("jack", 23));
            add(new User("james", 30));
            add(new User("curry", 28));
        }};
        List<String> collect8 = userList.stream().collect(Collectors.mapping(User::getName, Collectors.toList()));
        //[jack, james, curry]
        System.out.println(collect8);
    }
}
