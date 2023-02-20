package com.susan.demo.desginpattern.singleton;

/**
 * 饿汉模式，其实还有一个变种
 * <p>
 * 使用静态代码块的方式实例化INSTANCE对象。
 * <p>
 * 使用饿汉模式的好处是：没有线程安全的问题，但带来的坏处也很明显。
 * 一开始就实例化对象了，如果实例化过程非常耗时，并且最后这个对象没有被使用，不是白白造成资源浪费吗？
 *
 * @author sue
 * @date 2023/2/17 23:39
 */
public class SimpleSingleton2 {
    //持有自己类的引用
    private static final SimpleSingleton2 INSTANCE;

    static {
        INSTANCE = new SimpleSingleton2();
    }

    //私有的构造方法
    private SimpleSingleton2() {
    }

    //对外提供获取实例的静态方法
    public static SimpleSingleton2 getInstance() {
        return INSTANCE;
    }
}
