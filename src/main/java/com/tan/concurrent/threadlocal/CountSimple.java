package com.tan.concurrent.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountSimple {
	static ThreadLocal<SimpleDateFormat> cThreadLocal=new ThreadLocal<SimpleDateFormat>();
	
	static class ParseDate implements Runnable{
		int count=0;
		
		public ParseDate(int count){
			this.count=count;
		}

		@Override
		public void run() {
			if(cThreadLocal.get()==null){
				cThreadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:MM:SS"));
			}
			try {
				cThreadLocal.get().parse("2018-01-18 9:33:"+(count%60));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(20);
		for (int i = 0; i < 1000; i++) {
			es.execute(new ParseDate(i));
		}
	}
}
