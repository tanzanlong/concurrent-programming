package com.tan.concurrent.threadpool.api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**可缓存线程池：

  1.线程数无限制
  2.有空闲线程则复用空闲线程，若无空闲线程则新建线程
  3.一定程序减少频繁创建/销毁线程，减少系统开销  
 * @author Administrator
 *
 */
public class CachedThreadPoolSample {
 public static void main(String[] args) {
     ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
     cachedThreadPool.execute(new Runnable() {
        @Override
        public void run() {
            
        }
    });
    // ExecutorService cachedThreadPool = Executors.newfixe;
}
}
