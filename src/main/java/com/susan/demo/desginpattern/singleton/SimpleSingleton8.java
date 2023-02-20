package com.susan.demo.desginpattern.singleton;

/**
 * 通过反射创建的对象，跟通过getInstance方法获取的对象，并非同一个对象，
 * 也就是说，这个漏洞会导致SimpleSingleton5非单例。
 * <p>
 * 那么，要如何防止这个漏洞呢？
 * <p>
 * 答：这就需要在无参构造方式中判断，如果非空，则抛出异常了
 *
 * @author sue
 * @date 2023/2/17 23:45
 */
public class SimpleSingleton8 {

    private SimpleSingleton8() {
        if (Inner.INSTANCE != null) {
            throw new RuntimeException("不能支持重复实例化");
        }
    }

    public static SimpleSingleton8 getInstance() {
        return Inner.INSTANCE;
    }

    private static class Inner {
        private static final SimpleSingleton8 INSTANCE = new SimpleSingleton8();
    }
}
