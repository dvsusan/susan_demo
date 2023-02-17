package com.susan.demo.util;

import org.junit.jupiter.api.Test;
import org.springframework.util.ClassUtils;

/**
 * 主要介绍ClassUtils类的常用方法
 *
 * @author sue
 * @date 2023/2/17 23:13
 */
public class ClassUtilsTest {

    /**
     * 如果你想获取某个对象的所有接口，
     * 可以使用ClassUtils的getAllInterfaces方法
     */
    @Test
    public void testGetAllMethod() {
        Class<?>[] allInterfaces = ClassUtils.getAllInterfaces(new Object());
        System.out.println(allInterfaces);
    }

    /**
     * 如果你想获取某个类的包名，可以使用ClassUtils的getPackageName方法
     */
    @Test
    public void testPackageName() {
        String packageName = ClassUtils.getPackageName(Object.class);
        System.out.println(packageName);
    }

    /**
     * 如果你想判断某个类是否内部类，可以使用ClassUtils的isInnerClass方法
     */
    @Test
    public void testInnerClass() {
        System.out.println(ClassUtils.isInnerClass(Object.class));
    }

    /**
     * 如果你想判断对象是否代理对象，可以使用ClassUtils的isCglibProxy方法
     */
    @Test
    public void testProxy() {
        System.out.println(ClassUtils.isCglibProxy(new Object()));
    }
}
