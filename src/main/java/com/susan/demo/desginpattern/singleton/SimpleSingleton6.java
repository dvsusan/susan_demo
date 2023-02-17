package com.susan.demo.desginpattern.singleton;

/**
 * 在java虚拟机实际上会做一些优化，对一些代码指令进行重排。
 * 重排之后的顺序可能就变成了：1、3、2、4、5，这样在多线程的情况下同样会创建多次实例
 * <p>
 * 原来如此，那有什么办法可以解决呢？
 * <p>
 * 答：可以在定义INSTANCE是加上volatile关键字
 *
 * @author sue
 * @date 2023/2/17 23:43
 */
public class SimpleSingleton6 {

    private volatile static SimpleSingleton6 INSTANCE;

    private SimpleSingleton6() {
    }

    public static SimpleSingleton6 getInstance() {
        if (INSTANCE == null) {
            synchronized (SimpleSingleton6.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SimpleSingleton6();
                }
            }
        }
        return INSTANCE;
    }
}
