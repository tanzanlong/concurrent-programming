package com.tan.concurrent.interrupte;

public class BlockThreadInterrupteSimple {

	public static void main(String[] args) {
		final Thread t=new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
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
