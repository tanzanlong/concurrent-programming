package com.tan.concurrent.blokingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**用链表实现的有界阻塞队列。队列按照先进先出的原则对元素排序。默认情况下不保证访问者公平的访问队列。
 * 队列默认和最大长度Integer.MAX_VALUE。
 * 吞吐量。
 * 
 * @author baibei
 *
 */
public class LinkedBlookingQueueDemo {
 
	public static void main(String[] args) {
		
		LinkedBlockingQueue<String>fairqueue=new LinkedBlockingQueue<>(100);
		
		
		
	}
	
	
}
