package com.tan.concurrent.blokingqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**用数值实现的有界阻塞队列。队列按照先进先出的原则对元素排序。默认情况下不保证访问者公平的访问队列。
 * 即阻塞的所有生产者或消费者线程，先阻塞的线程，不一定能先访问元素或者插入元素。通常情况下保证公平性会降低
 * 吞吐量。
 * 
 * @author baibei
 *
 */
public class ArrayBlockingQueueDemo {
 
	public static void main(String[] args) {
		
		ArrayBlockingQueue<String>fairqueue=new ArrayBlockingQueue<>(100,true);
		
		
		
	}
	
	
}
