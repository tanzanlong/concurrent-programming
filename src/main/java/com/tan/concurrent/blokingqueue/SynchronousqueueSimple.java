package com.tan.concurrent.blokingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**没有容量 http://ifeve.com/java-synchronousqueue/
 * @author tan
 *
 */
public class SynchronousqueueSimple {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String>sys=new SynchronousQueue<String>();
		sys.offer("1111",1,TimeUnit.MINUTES);
		sys.offer("2222",1,TimeUnit.MINUTES);
		sys.offer("3333",1,TimeUnit.MINUTES);
	}
}
