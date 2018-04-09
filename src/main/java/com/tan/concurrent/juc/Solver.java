package com.tan.concurrent.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Solver {
	 final int N;
	   final float[][] data;
	   final CyclicBarrier barrier;
	   boolean isDone=false;

	   class Worker implements Runnable {
	     int myRow;
	     Worker(int row) { myRow = row; }
	     public void run() {
	       while (!isDone) {
	        System.out.println(" process row");

	         try {
	           barrier.await();
	         } catch (InterruptedException ex) {
	           return;
	         } catch (BrokenBarrierException ex) {
	           return;
	         }
	       }
	     }
	   }

	   public Solver(float[][] matrix) throws InterruptedException {
	     data = matrix;
	     N = matrix.length;
	     Runnable barrierAction =
	       new Runnable() { public void run() {  System.out.println(" merge row"); }};
	     barrier = new CyclicBarrier(N, barrierAction);

	     List<Thread> threads = new ArrayList<Thread>(N);
	     for (int i = 0; i < N; i++) {
	       Thread thread = new Thread(new Worker(i));
	       threads.add(thread);
	       thread.start();
	     }

	     // wait until done
	     for (Thread thread : threads)
	       thread.join();
	   }
}
