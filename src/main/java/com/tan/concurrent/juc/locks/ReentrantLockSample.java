package com.tan.concurrent.juc.locks;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReentrantLockSample {
    private static final Logger logger = LoggerFactory.getLogger(ReentrantLockSample.class);

    private final ReentrantLock lock = new ReentrantLock();
    
    public void getResource() {
        lock.lock();
        try {
            logger.info(" get lock and  order");
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        ReentrantReadWriteLock readwriteLock=new ReentrantReadWriteLock();
        readwriteLock.readLock();
    }
}
