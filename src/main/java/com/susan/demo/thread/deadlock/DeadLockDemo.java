package com.susan.demo.thread.deadlock;

/**
 * @author sue
 * @date 2023/2/16 19:02
 */
public class DeadLockDemo {
    public static final String obj1 = "obj1";
    public static final String obj2 = "obj2";

//    public static void main(String[] args) {
//        //锁A
//        LockA la = new LockA();
//        new Thread(la).start();
//
//        //锁B
//        LockB lb = new LockB();
//        new Thread(lb).start();
//    }
}

class LockA implements Runnable {
    @Override
    public void run() {
        try { //异常捕获
            System.out.println(" LockA 开始执行");
            while (true) {
                synchronized (DeadLockDemo.obj1) {
                    System.out.println(" LockA 锁住 obj1");

                    // 此处等待是给B能锁住机会
                    Thread.sleep(300);
                    synchronized (DeadLockDemo.obj2) {
                        System.out.println(" LockA 锁住 obj2");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class LockB implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println(" LockB 开始执行");
            while (true) {
                synchronized (DeadLockDemo.obj2) {
                    System.out.println(" LockB 锁住 obj2");
                    //给A能锁住机会
                    Thread.sleep(300);
                    synchronized (DeadLockDemo.obj1) {
                        System.out.println(" LockB 锁住 obj1");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
