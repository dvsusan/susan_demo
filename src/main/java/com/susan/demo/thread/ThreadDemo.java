package com.susan.demo.thread;

/**
 * 创建一个线程，也可以通过一个类去继承Thread类，然后创建一个该类的实例
 * 继承类必须重写 run() 方法，该方法是新线程的入口点。它也必须调用 start() 方法才能执行
 * 该方法尽管被列为一种多线程实现方式，但是本质上也是实现了 Runnable 接口的一个实例
 */
public class ThreadDemo extends Thread {
    /**
     * 线程对象
     * 这里使用构造 new Thread(Runnable threadOb,String threadName);
     */
    private Thread thread;

    /**
     * 指定新线程的名字
     */
    private final String threadName;

    public ThreadDemo(String name) {
        threadName = name;
        System.out.println("ThreadDemo Creating " + threadName);
    }

    /**
     * run方法里面实现线程工作内容
     */
    @Override
    public void run() {
        System.out.println("ThreadDemo Running " + threadName);
        try {
            int c = 5;
            while (c > 0) {
                System.out.println("Thread: " + threadName + ", " + c);
                c--;
                // 让线程睡眠一会 100ms
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("ThreadDemo Thread " + threadName + " interrupted.");
        } finally {
            System.out.println("ThreadDemo Thread " + threadName + " exiting.");
        }
    }

    /**
     * 需调用此方法，线程才开始运行
     */
    public void start() {
        System.out.println("ThreadDemo Starting " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}
