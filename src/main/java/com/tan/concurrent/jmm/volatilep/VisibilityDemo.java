package com.tan.concurrent.jmm.volatilep;

public class VisibilityDemo {
    public static void main(String[] args) throws InterruptedException {

        CountingThread backgroundThread = new CountingThread();

        backgroundThread.start();

        Thread.sleep(1000);

        backgroundThread.cancel();

        backgroundThread.join();

        System.out.printf("count:%s",backgroundThread.count);

        }
}
