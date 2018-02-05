package com.tan.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolSimple {
public static void main(String[] args) {
	ExecutorService	executorService = Executors.newFixedThreadPool(2);
	executorService.execute(new Runnable() {
		@Override
		public void run() {
			System.out.println("running");
		}
	});
}
}
