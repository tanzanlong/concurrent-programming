package com.tan.concurrent.thread;

public class JionSimple {
  volatile static int i=0 ;
		  
		  static class AddThread extends Thread{

			@Override
			public void run() {
				for ( i = 0; i < 100000; i++);
			}
	  
  }
		  
	public static void main(String[] args) throws InterruptedException {
		AddThread at = new AddThread();
		at.start();
		at.join();
		System.out.println(i);
	}
}
