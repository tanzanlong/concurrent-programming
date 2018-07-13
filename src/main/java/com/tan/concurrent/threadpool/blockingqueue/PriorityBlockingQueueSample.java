package com.tan.concurrent.threadpool.blockingqueue;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueSample {
    private PriorityBlockingQueue<Integer> linkedBlockingQueue = new PriorityBlockingQueue<Integer>(10);
    
    public static void main(String[] args) throws InterruptedException {
        final PriorityBlockingQueueSample arrayBlockingQueueTest = new PriorityBlockingQueueSample();
        new Thread(new Runnable() {
            public void run() {
                try {
                    arrayBlockingQueueTest.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                try {
                    arrayBlockingQueueTest.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
 
 
    }
 
    private void producer() throws InterruptedException {
        for(int i=0; i<100; i++) {
            System.out.println("arrayBlockingQueue.size()="+linkedBlockingQueue.size());
            //Thread.sleep(1000);
            //队列满了之后会直接抛出异常
            //arrayBlockingQueue.add(i);
            //队列满了之后会等待队列腾出空间
            //arrayBlockingQueue.put(i);
            //将指定的元素插入到此队列的尾部（如果立即可行且不会超过该队列的容量），在成功时返回 true，如果此队列已满，则返回 false。
            linkedBlockingQueue.offer(i);
 
        }
    }
 
    private void consumer() throws InterruptedException {
        while(true) {
            //Thread.sleep(1000);
            //获取并移除此队列的头部，在指定的等待时间前等待可用的元素。如果已经没有可用的元素，则没10s返回一个null
            // System.out.println(arrayBlockingQueue.poll(10000, TimeUnit.MILLISECONDS));
            //获取并移除此队列的头部，在元素变得可用之前一直等待
            System.out.println(linkedBlockingQueue.take());
            //获取但不移除此队列的头；如果此队列为空，则返回 null
            //System.out.println(arrayBlockingQueue.peek());
        }
    }

}
