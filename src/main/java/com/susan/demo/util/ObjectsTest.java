package com.susan.demo.util;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * 主要介绍Objects类中常用的方法
 *
 * @author sue
 * @date 2023/2/17 22:55
 */
public class ObjectsTest {


    /**
     * 在java中万事万物皆对象，对象的判空可以说无处不在。
     * Objects的isNull方法判断对象是否为空，而nonNull方法判断对象是否不为空
     */
    @Test
    public void testObjectNull() {
        Integer integer = new Integer(1);

        if (Objects.isNull(integer)) {
            System.out.println("对象为空");
        }

        if (Objects.nonNull(integer)) {
            System.out.println("对象不为空");
        }
    }

    /**
     * 如果我们想在对象为空时，抛出空指针异常，
     * 可以使用Objects的requireNonNull方法
     */
    @Test
    public void testNullException() {
        Integer integer1 = new Integer(128);

        Objects.requireNonNull(integer1);
        Objects.requireNonNull(integer1, "参数不能为空");
        Objects.requireNonNull(integer1, () -> "参数不能为空");
    }

    /**
     * 我们经常需要判断两个对象是否相等，
     * Objects给我们提供了equals方法
     */
    @Test
    public void testCompareObject() {
        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(1);

        System.out.println(Objects.equals(integer1, integer2));
    }

    /**
     * 如果你想获取某个对象的hashCode，
     * 可以使用Objects的hashCode方法
     */
    @Test
    public void testHashCode() {
        String str = new String("abc");
        System.out.println(Objects.hashCode(str));
    }
}
