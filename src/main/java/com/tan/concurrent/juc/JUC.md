http://www.iocoder.cn/JUC/good-collection/

Synchronized

实现原理
synchronized可以保证方法或者代码块在运行时，同一时刻只有一个方法可以进入到临界区，同时它还可以保证共享变量的内存可见性

Java中每一个对象都可以作为锁，这是synchronized实现同步的基础：

1.普通同步方法，锁是当前实例对象

2.静态同步方法，锁是当前类的class对象

3.同步方法块，锁是括号里面的对象






CyclicBarrier 

是什么？

一个同步辅助类。它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)。在涉及一组固定大小的线程的程序中，这些线程必须不时地互相等待，此时 CyclicBarrier 很有用。因为该 barrier 在释放等待线程后可以重用，所以称它为循环 的 barrier。



CountDownLatch

在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待
