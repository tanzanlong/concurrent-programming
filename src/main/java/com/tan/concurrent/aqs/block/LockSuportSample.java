package com.tan.concurrent.aqs.block;

import java.util.concurrent.locks.LockSupport;

public class LockSuportSample {
    public static Object object = new Object();
    static TestThread t1 = new TestThread("线程1");
    static TestThread t2 = new TestThread("线程2");
    public static class TestThread extends Thread{
        public TestThread(String name) {
            super.setName(name);
        }
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(getName()+" 占用。。");
//                Thread.currentThread().suspend();
               LockSupport.park();
               LockSupport.park();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(200);
        t2.start();
        t1.resume();
        LockSupport.unpark(t1);
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t2.resume();
        t1.join();
        t2.join();
    }
}
