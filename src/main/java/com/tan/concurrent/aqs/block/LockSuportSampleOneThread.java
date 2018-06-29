package com.tan.concurrent.aqs.block;

import java.util.concurrent.locks.LockSupport;

public class LockSuportSampleOneThread {
    public static void main(String[] args) {
        LockSupport.unpark(Thread.currentThread());//释放许可  
        LockSupport.park();// 获取许可  
    }
}
