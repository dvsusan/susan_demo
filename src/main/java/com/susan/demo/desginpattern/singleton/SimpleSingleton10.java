package com.susan.demo.desginpattern.singleton;

/**
 * 其实在java中枚举就是天然的单例，每一个实例只有一个对象，
 * 这是java底层内部机制保证的。
 *
 * @author sue
 * @date 2023/2/17 23:48
 */
public enum SimpleSingleton10 {

    INSTANCE;

    /**
     * 方法
     */
    public void doSamething() {
        System.out.println("doSamething");
    }
}
