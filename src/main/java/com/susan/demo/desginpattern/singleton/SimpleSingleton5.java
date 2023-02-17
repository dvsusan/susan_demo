package com.susan.demo.desginpattern.singleton;

/**
 * 双重检查锁顾名思义会检查两次：在加锁之前检查一次是否为空，加锁之后再检查一次是否为空。
 *
 * @author sue
 * @date 2023/2/17 23:42
 */
public class SimpleSingleton5 {

    private static SimpleSingleton5 INSTANCE;

    private SimpleSingleton5() {
    }

    public static SimpleSingleton5 getInstance() {
        if (INSTANCE == null) {
            synchronized (SimpleSingleton5.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SimpleSingleton5();
                }
            }
        }
        return INSTANCE;
    }
}
