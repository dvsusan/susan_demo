package com.susan.demo.desginpattern.singleton;

/**
 * 饿汉模式
 * 实例在初始化的时候就已经建好了，不管你有没有用到，先建好了再说
 *
 * @author sue
 * @date 2023/2/17 23:38
 */
public class SimpleSingleton1 {
    //持有自己类的引用
    private static final SimpleSingleton1 INSTANCE = new SimpleSingleton1();

    //私有的构造方法
    private SimpleSingleton1() {
    }

    //对外提供获取实例的静态方法
    public static SimpleSingleton1 getInstance() {
        return INSTANCE;
    }
}
