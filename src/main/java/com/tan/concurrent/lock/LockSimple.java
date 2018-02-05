package com.tan.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSimple {
 public static void main(String[] args) {
	 /**
	  * lock.lock()不写在try里面，写在里面可能会导致在或者锁异常的时候也会释放锁。
	  */
	Lock lock=new ReentrantLock();
	lock.lock(); 
	System.out.println(" first lock");
	lock.lock();
	System.out.println(" second lock");
	try{
		
	}catch(Exception e){
		lock.unlock();
	}
	lock.lock();
}
}

