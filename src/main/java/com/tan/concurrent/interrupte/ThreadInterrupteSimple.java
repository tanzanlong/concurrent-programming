package com.tan.concurrent.interrupte;

public class ThreadInterrupteSimple {

	public static void main(String[] args) {
		final Thread t=new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					if(Thread.currentThread().isInterrupted()){
						System.out.println(" ... interrupted ....");
						break;
					}
				}
			}
		});
		
		final Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				t.interrupt();
			}
		});

		t.start();
		t2.start();
		
	}
}
