package com.tan.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExtThreadPoolDemo {

	
	public static void main(String[] args) throws InterruptedException {
		
		/**
		 * new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler)
		 */
		ExecutorService es=new ThreadPoolExecutor(3, 3, 0, 
				TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>(10)) {

					@Override
					protected void beforeExecute(Thread t, Runnable r) {
						System.out.println("准备执行："+((Mytask)r).name);
					}

					@Override
					protected void afterExecute(Runnable r, Throwable t) {
						System.out.println("执行完成："+((Mytask)r).name);
					}

					@Override
					protected void terminated() {
						System.out.println("线程池退出");
					}
			
		};
		for (int i = 0; i < 100; i++) {
			Mytask task=new Mytask("task-geym-"+i);
			es.execute(task);
			Thread.sleep(10);
		}
		es.shutdown();
		
		
	}
	
	static class Mytask implements Runnable{
		public String name;
		
		public Mytask(String name){
			this.name=name;
		}

		@Override
		public void run() {
         System.out.println(" 正在执行thread id:"+Thread.currentThread().getId()+" ,task name="+name);
			try {
				Thread.sleep(100);
			}catch(Exception e) {
				
			}
		}
		
	}
}
