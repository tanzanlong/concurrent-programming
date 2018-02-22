package com.tan.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池可以无限的创建线程，导致内存溢出 。
 * @author tan
 *
 */
public class CachedThreadPoolUnboundingSimple {
	public static void main(String[] args) {  
		  
        ExecutorService executorService = Executors.newCachedThreadPool();  
        for (int i = 1; i < 10000; i++)  
            executorService.submit(new task());  
  
    }  
  
}  
  
class task implements Runnable {  
  
    @Override  
    public void run() {  
        try {  
            Thread.sleep(500000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
  
    }  
}
