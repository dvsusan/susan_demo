package com.susan.demo.desginpattern.singleton;

/**
 * 懒汉模式
 * <p>
 * 顾名思义就是实例在用到的时候才去创建，“比较懒”，用的时候才去检查有没有实例，
 * 如果有则返回，没有则新建
 *
 * @author sue
 * @date 2023/2/17 23:40
 */
public class SimpleSingleton3 {

    private static SimpleSingleton3 INSTANCE;

    private SimpleSingleton3() {
    }

    public static SimpleSingleton3 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SimpleSingleton3();
        }
        return INSTANCE;
    }
}
