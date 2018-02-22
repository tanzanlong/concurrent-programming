package com.tan.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RejectThreadPoolDemo {

	
	public static void main(String[] args) {
		Mytask task=new Mytask();
		/**
		 * new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler)
		 */
		ExecutorService es=new ThreadPoolExecutor(3, 3, 0, 
				TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>(10), new RejectedExecutionHandler() {
					
					@Override
					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
						// TODO Auto-generated method stub
						System.out.println(r.toString()+" is discard");
					}
				});
		for (int i = 0; i < 100; i++) {
			es.submit(task);
		}
		
		
		
	}
	
	static class Mytask implements Runnable{

		@Override
		public void run() {
         System.out.println(System.currentTimeMillis()+":  thread id:"+Thread.currentThread().getId());
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				
			}
		}
		
	}
}
