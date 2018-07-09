package com.tan.concurrent.thread.waitnotify;

/**
 * wait 和 notify的调用都需要先获得对象监视器 所以都需要配合 synchronized使用  wait调用后会释放对象监视器 ，线程会被加入等待队列，notify调用时会随机唤醒一个线程。
 * @author tan
 *
 */
public class WaitAndNotifySimple {
	
	public static void main(String[] args) {
		
	final	Object obj=new Object();
		
		Thread t1=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (obj) {
						obj.wait();
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"t1");
		
		
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (obj) {
					obj.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"t2");
		
		Thread t3=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (obj) {
					obj.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"t3");
		
		
		Thread t4=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (obj) {
					obj.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"t4");
		
		Thread t5=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (obj) {
					obj.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();/**/
		t5.start();
		synchronized (obj) {
			obj.notify();
		}
		
	}
	

}
