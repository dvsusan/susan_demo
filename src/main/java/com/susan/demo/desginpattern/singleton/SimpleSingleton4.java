package com.susan.demo.desginpattern.singleton;

/**
 * 懒汉模式中，假如有多个线程中都调用了getInstance方法，
 * 那么都走到 if (INSTANCE == null) 判断时，可能同时成立，因为INSTANCE初始化时默认值是null。
 * 这样会导致多个线程中同时创建INSTANCE对象，即INSTANCE对象被创建了多次，
 * 违背了只创建一个INSTANCE对象的初衷。
 * <p>
 * 那么，要如何改进呢？
 * <p>
 * 答：最简单的办法就是使用synchronized关键字
 *
 * @author sue
 * @date 2023/2/17 23:41
 */
public class SimpleSingleton4 {
    private static SimpleSingleton4 INSTANCE;

    private SimpleSingleton4() {
    }

    public synchronized static SimpleSingleton4 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SimpleSingleton4();
        }
        return INSTANCE;
    }
}
