package com.tan.concurrent.jmm.volatilep;

public class CountingThread extends Thread{
  //线程停止标志

    private volatile boolean ready = false;

    public int count = 0;

    @Override

    public void run() {

    while (!ready) {

    count++;

    }

    }

    public void cancel() {

    ready = true;

    }

}
