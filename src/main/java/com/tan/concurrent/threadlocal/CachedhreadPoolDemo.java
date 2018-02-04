package com.tan.concurrent.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedhreadPoolDemo {

	
	public static void main(String[] args) {
		Mytask task=new Mytask();
		ExecutorService es=Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
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
