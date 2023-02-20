package com.susan.demo.thread;

/**
 * 创建一个线程，最简单的方法是创建一个实现 Runnable 接口的类。
 * 为了实现 Runnable，一个类只需要执行一个方法调用 run()，声明如下：
 * public void run()
 * 你可以重写该方法，重要的是理解的 run() 可以调用其他方法，使用其他类，并声明变量，就像主线程一样
 * 新线程创建之后，你调用它的 start() 方法它才会运行
 */
public class RunnableDemo implements Runnable {

    /**
     * 线程对象
     * 这里使用构造 new Thread(Runnable threadOb, String threadName);
     */
    private Thread thread;

    /**
     * 指定新线程的名字
     */
    private final String threadName;

    public RunnableDemo(String name) {
        threadName = name;
        System.out.println("RunnableDemo Creating " + threadName);
    }

    /**
     * run方法里面实现线程工作内容
     */
    @Override
    public void run() {
        System.out.println("RunnableDemo Running " + threadName);
        try {
            int c = 5;
            do {
                System.out.println("RunnableDemo Thread: " + threadName + ", " + c);
                c--;
                // 让线程睡眠一会 100ms
                Thread.sleep(100);
            } while (c > 0);
        } catch (InterruptedException e) {
            System.out.println("RunnableDemo Thread " + threadName + " interrupted.");
        } finally {
            System.out.println("RunnableDemo Thread " + threadName + " exiting.");
        }
    }

    /**
     * 需调用此方法，线程才开始运行
     */
    public void start() {
        System.out.println("RunnableDemo Starting " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

}
