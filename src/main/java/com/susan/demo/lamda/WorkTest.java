package com.susan.demo.lamda;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 实际案例，后续会持续更新
 *
 * @author sue
 * @date 2023/2/16 18:53
 */
public class WorkTest {

    /**
     * 从两个集合中找相同的元素。一般用于批量数据导入的场景，先查询出数据，再批量新增或修改。
     */
    @Test
    public void testWork1() {
        List<String> list1 = Lists.newArrayList("a", "b", "ab");
        List<String> list2 = Lists.newArrayList("a", "c", "ab");
        List<String> collect = list1.stream()
                .filter(x -> list2.stream().anyMatch(e -> e.equals(x)))
                .collect(Collectors.toList());
        //结果：[a, ab]
        System.out.println(collect);
    }

    /**
     * 有两个集合a和b，过滤出集合a中有，但是集合b中没有的元素。
     * 这种情况可以使用在假如指定一个id集合，根据id集合从数据库中查询出数据集合，
     * 再根据id集合过滤出数据集合中不存在的id，这些id就是需要新增的。
     */
    @Test
    public void testWork2() {
        List<String> list1 = Lists.newArrayList("a", "b", "ab");
        List<String> list2 = Lists.newArrayList("a", "c", "ab");
        List<String> collect = list1.stream()
                .filter(x -> list2.stream().noneMatch(e -> e.equals(x)))
                .collect(Collectors.toList());
        //结果：[b]
        System.out.println(collect);
    }


    /**
     * 根据条件过滤数据，并且去重做数据转换
     */
    @Test
    public void testWork3() {
        List<User> userList = new ArrayList<User>() {{
            add(new User("jack", 23));
            add(new User("james", 30));
            add(new User("curry", 28));
            add(new User("tom", 27));
            add(new User("sue", 29));
        }};

        List<String> collect = userList.stream()
                .filter(x -> x.getAge() > 27)
                .sorted((a, b) -> a.getAge().compareTo(b.getAge()))
                .limit(2)
                .map(User::getName)
                .collect(Collectors.toList());
        //结果：[curry, sue]
        System.out.println(collect);
    }

    /**
     * 统计指定集合中，姓名相同的人中年龄最小的年龄
     */
    @Test
    public void testWork4() {
        List<User> userList = new ArrayList<User>() {{
            add(new User("tom", 23));
            add(new User("james", 30));
            add(new User("james", 28));
            add(new User("tom", 27));
            add(new User("sue", 29));
        }};

        userList.stream().collect(Collectors.groupingBy(User::getName))
                .forEach((name, list) -> {
                    User user = list.stream().sorted((a, b) -> a.getAge().compareTo(b.getAge())).findFirst().orElse(null);
                    //结果：name:sue,age:29
                    //     name:tom,age:23
                    //     name:james,age:28
                    System.out.println("name:" + name + ",age:" + user.getAge());
                });
    }


    @AllArgsConstructor
    @Data
    class User {
        private String name;
        private Integer age;
    }
}
