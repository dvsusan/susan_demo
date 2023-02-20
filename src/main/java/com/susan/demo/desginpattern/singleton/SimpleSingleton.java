package com.susan.demo.desginpattern.singleton;

/**
 * 单例模式是一种非常常用的软件设计模式，它定义是单例对象的类只能允许一个实例存在。
 * <p>
 * 该类负责创建自己的对象，同时确保只有一个对象被创建。一般常用在工具类的实现或创建对象需要消耗资源的业务场景。
 * <p>
 * 单例模式的特点：
 * <p>
 * 类构造器私有
 * 持有自己类的引用
 * 对外提供获取实例的静态方法
 * 我们先用一个简单示例了解一下单例模式的用法
 *
 * @author sue
 * @date 2023/2/17 23:37
 */
public class SimpleSingleton {
    //持有自己类的引用
    private static final SimpleSingleton INSTANCE = new SimpleSingleton();

    //私有的构造方法
    private SimpleSingleton() {
    }

    //对外提供获取实例的静态方法
    public static SimpleSingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(SimpleSingleton.getInstance().hashCode());
        System.out.println(SimpleSingleton.getInstance().hashCode());
    }
}
