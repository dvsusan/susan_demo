package com.susan.demo.util;

import org.apache.commons.lang3.BooleanUtils;
import org.junit.jupiter.api.Test;

/**
 * 主要介绍BooleanUtils类下的常用方法
 *
 * @author sue
 * @date 2023/2/17 22:58
 */
public class BooleanUtilsTest {

    /**
     * 如果你想判断某个参数的值是true或false，
     * 可以直接使用isTrue或isFalse方法
     */
    @Test
    public void testTrueOrFalse() {
        Boolean aBoolean = new Boolean(true);
        System.out.println(BooleanUtils.isTrue(aBoolean));
        System.out.println(BooleanUtils.isFalse(aBoolean));
    }

    /**
     * 有时候，需要判断某个参数不为true，即是null或者false。
     * 或者判断不为false，即是null或者true。
     * <p>
     * 可以使用isNotTrue或isNotFalse方法
     */
    @Test
    public void testIsNotTrueOrFalse() {
        Boolean aBoolean = new Boolean(true);
        Boolean aBoolean1 = null;
        System.out.println(BooleanUtils.isNotTrue(aBoolean));
        System.out.println(BooleanUtils.isNotTrue(aBoolean1));
        System.out.println(BooleanUtils.isNotFalse(aBoolean));
        System.out.println(BooleanUtils.isNotFalse(aBoolean1));
    }

    /**
     * 如果你想将true转换成数字1，false转换成数字0，
     * 可以使用toInteger方法
     */
    @Test
    public void testToInteger() {
        Boolean aBoolean = new Boolean(true);
        Boolean aBoolean1 = new Boolean(false);
        System.out.println(BooleanUtils.toInteger(aBoolean));
        System.out.println(BooleanUtils.toInteger(aBoolean1));
    }

    /**
     * 我们有时候需要将包装类Boolean对象，转换成原始的boolean对象，
     * 可以使用toBoolean方法
     */
    @Test
    public void testToBoolean() {
        Boolean aBoolean = new Boolean(true);
        Boolean aBoolean1 = null;
        System.out.println(BooleanUtils.toBoolean(aBoolean));
        System.out.println(BooleanUtils.toBoolean(aBoolean1));
        System.out.println(BooleanUtils.toBooleanDefaultIfNull(aBoolean1, false));
    }
}
