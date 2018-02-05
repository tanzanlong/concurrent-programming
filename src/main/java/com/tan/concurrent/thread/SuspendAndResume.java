package com.tan.concurrent.thread;

public class SuspendAndResume {
	
 private static final Object obj=new Object();	
 
 static ChangeObjectThread changeObjectThread1=new ChangeObjectThread("t1");
 
 static ChangeObjectThread changeObjectThread2=new ChangeObjectThread("t2");
	
 public static void main(String[] args) throws InterruptedException {
	 changeObjectThread1.start();
	 Thread.sleep(1000);
	 changeObjectThread2.start();
	 changeObjectThread1.resume();
	 changeObjectThread2.resume();
}
 
 
 
  static class ChangeObjectThread extends Thread{
	  public ChangeObjectThread(String name){
		  super.setName(name);
	  }

	@Override
	public void run() {
		synchronized (obj) {
			System.out.println("enter "+getName());
			Thread.currentThread().suspend();
		}
	}
	  
	  
  }
 
 
}
