package com.tan.concurrent.lock.rwlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachedData {
	String data;
	volatile boolean cacheValid;
	ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	void processCachedData() {
		System.out.println(" 线程：" + Thread.currentThread().getName() + " ：1 ");
		rwl.readLock().lock();// @1
		System.out.println(" 线程：" + Thread.currentThread().getName() + " ：2 ");
		if (!cacheValid) {
			// Must release read lock before acquiring write lock
			rwl.readLock().unlock();// @4
			rwl.writeLock().lock();// @2
			// Recheck state because another thread might have acquired
			// write lock and changed state before we did.
			if (!cacheValid) {// @3
				data = "123";
				cacheValid = true;
			}
			// Downgrade by acquiring read lock before releasing write lock
			rwl.readLock().lock();
			rwl.writeLock().unlock(); // Unlock write, still hold read
		}

		System.out.println(data);
		;
		rwl.readLock().unlock();
	}

}
