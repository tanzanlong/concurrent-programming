package com.tan.concurrent.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**http://ifeve.com/%E4%BD%BF%E7%94%A8threadlocal%E4%B8%8D%E5%BD%93%E5%8F%AF%E8%83%BD%E4%BC%9A%E5%AF%BC%E8%87%B4%E5%86%85%E5%AD%98%E6%B3%84%E9%9C%B2/
 * @author Administrator
 *
 */
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
