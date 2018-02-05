 什么是阻塞队列？
   是一个支持两个附加操作的队列。在队列为空时，获取元素的线程会等待队列变为非空。当队列满时，存储元素的线程会等待队列可用。
   
阻塞队列的api提供了四种处理方法
方法／处理方式           抛出异常           返回特殊值            一直阻塞             超时退出 

插入方法                      add(e)                       offer(e)              put(e)                    offer(e,time,unit)

移除方法                      remove()                    poll()                take()                     poll()

检查方法                      element()                   peek()               不可用                   不可用

抛出异常：当队列满时，往队列里插入元素，会抛出IllegalStateException(“Queue full”)异常。
当队列空时，从队列里获取元素时会抛出NoSuchElementException异常。

返回特殊值：插入方法会返回是否成功，成功则返回true。移除方法，则是从队列里拿出一个元素，如果没有则返回null。

一直阻塞： 当队列满时，往队列里put元素，队列会一直阻塞线程。直到拿到数据，或者响应中断退出。当队列为空时，线程从队列take元素，队列也会阻塞线程，直到队列可用。

jdk提供的7个阻塞队列：

ArrayBlockingQueue ：一个由数组结构组成的有界阻塞队列。
LinkedBlockingQueue ：一个由链表结构组成的有界阻塞队列。
PriorityBlockingQueue ：一个支持优先级排序的无界阻塞队列。
DelayQueue：一个使用优先级队列实现的无界阻塞队列。
SynchronousQueue：一个不存储元素的阻塞队列。
LinkedTransferQueue：一个由链表结构组成的无界阻塞队列。
LinkedBlockingDeque：一个由链表结构组成的双向阻塞队


http://ifeve.com/java-blocking-queue/
































