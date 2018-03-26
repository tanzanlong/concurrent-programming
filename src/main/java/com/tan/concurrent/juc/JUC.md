http://www.iocoder.cn/JUC/good-collection/

Synchronized

实现原理
synchronized可以保证方法或者代码块在运行时，同一时刻只有一个方法可以进入到临界区，同时它还可以保证共享变量的内存可见性

Java中每一个对象都可以作为锁，这是synchronized实现同步的基础：

1.普通同步方法，锁是当前实例对象

2.静态同步方法，锁是当前类的class对象

3.同步方法块，锁是括号里面的对象
