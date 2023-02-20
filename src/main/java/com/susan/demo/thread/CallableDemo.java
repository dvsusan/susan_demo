package com.susan.demo.thread;

import java.util.concurrent.Callable;

/**
 * 通过 Callable 和 Future 创建线程，与 Runnable 接口创建线程的方式有点类似
 * 创建 Callable 接口的实现类，并实现 call() 方法，该 call() 方法将作为线程执行体，并且有返回值
 * 创建 Callable 实现类的实例，使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值
 * 使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程
 * 调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值
 */
public class CallableDemo implements Callable<Integer> {
    private final int num;

    public CallableDemo(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable-" + Thread.currentThread().getName() + " 正在运行 ... 求和：" + num);
        int sum = 0;
        // 求和
        for (int i = 0; i < num; i++) {
            sum += i;
        }
        return sum;
    }
}
