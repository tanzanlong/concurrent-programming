package com.tan.concurrent.interrupte;

public class InterrupteDescription {
 /**
 * @param args
 */
public static void main(String[] args) {

	Thread t=new Thread();
	/**
	 *  设置中断
	 */
	t.interrupt();
	/**
	 *  判断中断标识
	 */
	t.isInterrupted();
	/**
	 *  判断中断标识 并清除中断标识
	 */
	Thread.currentThread().interrupted();
}
}
