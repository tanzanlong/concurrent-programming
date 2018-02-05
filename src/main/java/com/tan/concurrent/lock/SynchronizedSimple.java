package com.tan.concurrent.lock;

public class SynchronizedSimple {
 public static void main(String[] args) {
	Object obj=new Object();
	synchronized (obj) {
		System.out.println(" first synchronized");
		synchronized (obj) {
			System.out.println(" second synchronized");
		}
		
	}
}
}
