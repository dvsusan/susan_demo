package com.susan.demo.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * 主要介绍BeanUtils下的常用方法
 *
 * @author sue
 * @date 2023/2/17 23:17
 */
public class BeanUtilsTest {

    /**
     * 曾几何时，你有没有这样的需求：把某个对象中的所有属性，都拷贝到另外一个对象中。
     * 这时就能使用BeanUtils的copyProperties方法
     */
    @Test
    public void testCopyObject() {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("苏三说技术");
        user1.setAddress("成都");

        User user2 = new User();
        BeanUtils.copyProperties(user1, user2);
        System.out.println(user2);
    }

    /**
     * 如果你想通过反射实例化一个类的对象，可以使用BeanUtils的instantiateClass方法
     */
    @Test
    public void testInstanceObject() {
        User user = BeanUtils.instantiateClass(User.class);
        System.out.println(user);
    }

    /**
     * 如果你想获取某个类的指定方法，可以使用BeanUtils的findDeclaredMethod方法
     */
    @Test
    public void testGetMethod() {
        Method declaredMethod = BeanUtils.findDeclaredMethod(User.class, "getId");
        System.out.println(declaredMethod.getName());
    }

    /**
     * 如果你想获取某个方法的参数，可以使用BeanUtils的findPropertyForMethod方法
     */
    @Test
    public void testGetParam() {
        Method declaredMethod = BeanUtils.findDeclaredMethod(User.class, "getId");
        PropertyDescriptor propertyForMethod = BeanUtils.findPropertyForMethod(declaredMethod);
        System.out.println(propertyForMethod.getName());
    }
}
