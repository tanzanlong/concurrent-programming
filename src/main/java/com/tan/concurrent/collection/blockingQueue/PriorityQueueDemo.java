package com.tan.concurrent.collection.blockingQueue;

import java.util.PriorityQueue;

/**
 * 优先队列是一个无界数组，它的实现基于优先堆，默认最小堆。即根节点最小。左右没有大小规律。排序可以根据自然排序或者根据构造时候传入
 * 的Comparator，优先队列不允许有null节点
 * @author Administrator
 *
 */
public class PriorityQueueDemo {
 public static void main(String[] args) {
	 PriorityQueue<String> priorityQueue=new PriorityQueue<String>();
	 priorityQueue.add("1");
	 priorityQueue.add("5");
	 priorityQueue.add("3");
	 priorityQueue.add("2");
	 while (!priorityQueue.isEmpty()) {
		 System.out.println(priorityQueue.poll());
	}
	 
	 PriorityQueue<String> priorityQueue1=new PriorityQueue<String>(new StringComparator());
	 priorityQueue1.add("1");
	 priorityQueue1.add("5");
	 priorityQueue1.add("3");
	 priorityQueue1.add("2");
	 while (!priorityQueue1.isEmpty()) {
		 System.out.println(priorityQueue1.poll());
	}
}
 
 
 
 
}
