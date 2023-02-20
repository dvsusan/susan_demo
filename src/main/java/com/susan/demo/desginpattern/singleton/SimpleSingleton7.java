package com.susan.demo.desginpattern.singleton;

/**
 * 静态内部类顾名思义是通过静态的内部类来实现单例模式的。
 *
 * @author sue
 * @date 2023/2/17 23:44
 */
public class SimpleSingleton7 {

    private SimpleSingleton7() {
    }

    public static SimpleSingleton7 getInstance() {
        return Inner.INSTANCE;
    }

    private static class Inner {
        private static final SimpleSingleton7 INSTANCE = new SimpleSingleton7();
    }
}
