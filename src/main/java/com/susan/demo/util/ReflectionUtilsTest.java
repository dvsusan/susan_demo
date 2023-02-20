package com.susan.demo.util;

import org.junit.jupiter.api.Test;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 主要介绍ReflectionUtils类的常用方法
 *
 * @author sue
 * @date 2023/2/17 23:21
 */
public class ReflectionUtilsTest {

    /**
     * 如果你想获取某个类的某个方法，可以使用ReflectionUtils类的findMethod方法
     */
    @Test
    public void testGetMethod() {
        Method method = ReflectionUtils.findMethod(User.class, "getId");
    }

    /**
     * 如果你想获取某个类的某个字段，可以使用ReflectionUtils类的findField方法
     */
    @Test
    public void testGetField() {
        Field field = ReflectionUtils.findField(User.class, "id");
    }

    /**
     * 如果你想判断某个字段是否常量，可以使用ReflectionUtils类的isPublicStaticFinal方法
     */
    @Test
    public void testConstant() {
        Field field = ReflectionUtils.findField(User.class, "id");
        System.out.println(ReflectionUtils.isPublicStaticFinal(field));
    }

    /**
     * 如果你想判断某个方法是否equals方法，
     * 可以使用ReflectionUtils类的isEqualsMethod方法
     */
    @Test
    public void testEquals() {
        Method method = ReflectionUtils.findMethod(User.class, "getId");
        System.out.println(ReflectionUtils.isEqualsMethod(method));
    }
}
