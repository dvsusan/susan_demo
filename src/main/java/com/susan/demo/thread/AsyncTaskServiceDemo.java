package com.susan.demo.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 通过线程池创建线程任务 demo1
 */
@Service
public class AsyncTaskServiceDemo {

    /**
     * poolDemo 即配置线程池的方法名，此处如果不写自定义线程池的方法名，会使用默认的线程池
     *
     * @param i
     * @throws InterruptedException
     */
    @Async("poolDemo")
    public void doTask01(int i) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "_" + i + " task01 started... do something");
    }

    /**
     * poolDemo 即配置线程池的方法名，此处如果不写自定义线程池的方法名，会使用默认的线程池
     *
     * @param i
     * @throws InterruptedException
     */
    @Async("poolDemo")
    public void doTask02(int i) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "_" + i + " task02 started... do something");
    }

    /**
     * 此处不写自定义线程池的方法名，会使用默认的线程池
     *
     * @param i
     * @throws InterruptedException
     */
    @Async
    public void doTask03(int i) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "_" + i + " native task03 started... do something");
    }
}
