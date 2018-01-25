# concurrent-programming
concurrent-programming

ExecutorService通过Executors配置的几种线程池来处理每一个提交的任务。

线程池通常用来解决两类问题：
1. 当需要执行大量异步任务时，通过减少每个任务执行的时间，来提高性能。

假设一个服务器完成一项任务所需时间为：T1 创建线程时间，T2 在线程中执行任务的时间，T3 销毁线程时间。

    如果：T1 + T3 远大于 T2，则可以采用线程池，以提高服务器性能。
                一个线程池包括以下四个基本组成部分：
                1、线程池管理器（ThreadPool）：用于创建并管理线程池，包括 创建线程池，销毁线程池，添加新任务；
                2、工作线程（PoolWorker）：线程池中线程，在没有任务时处于等待状态，可以循环的执行任务；
                3、任务接口（Task）：每个任务必须实现的接口，以供工作线程调度任务的执行，它主要规定了任务的入口，任务执行完后的收尾工作，任务的执行状态等；
                4、任务队列（taskQueue）：用于存放没有处理的任务。提供一种缓冲机制。
                
    线程池技术正是关注如何缩短或调整T1,T3时间的技术，从而提高服务器程序性能的。它把T1，T3分别安排在服务器程序的启动和结束的时间段或者一些空闲的时间段，这样在服务器程序处理客户请求时，不会有T1，T3的开销了。


2.管理和界定资源。包括线程和任务执行集合的消费。

3.每个ThreadPoolExecutor还维护了一些基本的统计信息，比如已完成的任务数。


 为了迎合线程池技术的广泛使用场景，ThreadPoolExecutor提供了许多调整参数和扩展点（hooks）。不过我们鼓励程序员用下面这些快捷的工厂方法来预先配置
 大多数场景下的使用。
 
 Executors的newCachedThreadPool创建线程池。这种方法创建的线程池有以下特点：
  1. 无界:即可以新建无限数量的线程。实际最大为Integer.MAX_VALUE数量的线程。
  2. 自动回收线程。
  
 Executors的newFixedThreadPool创建线程池。 它会创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 
  Executors的newScheduledThreadPool 创建线程池。 它会创建一个定长线程池，支持定时及周期性任务执行

 Executors的newSingleThreadExecutor创建线程池。 它会一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 
 
 主要配置参数 
 
 core size和 maximun size。
 线程池会根据core size和maximun size设定的边界来动态调整pool size的大小 。execute提交任务过来时，如果正在运行的线程数量小于corePoolSize。线程池会新建一个线程来跑这个任务。即使其他线程也处于空闲的状态。
 如果正在运行的线程数量大于corePoolSize小于maximumPoolSize的并且队列是满的时候，线程池会新建线程来处理任务。通过将corePoolSize和maximumPoolSize设定成一样的值，你就可以得到一个固定大小的线程池，通过将maximumPoolSize
 设成无限大，比如Integer.MAX_VALUE，你就可以得到一个可以适应处理任意大并发任务的线程池。corePoolSize和maximumPoolSize通常通过构造器参数设置，但是我们也可以通过set方法动态修改。
 
  默认，即使核心线程也是在任务到达后才会被创建，不过，我们可以通过重写prestartCoreThread和prestartAllCoreThreads方法来修改逻辑。比如在初始化线程池的时候即使构造了一个空队列你也想先创建好这些线程。
  
  线程的创建 
  线程会通过一个ThreadFactory被创建，如果没有特别指定，会通过Executors的defaultThreadFactory方法被创建。这些线程会被放在同一个ThreadGroup，并且都有相同 的优先级（priority）。并且是非daemon状态。
  
  
 队列
 当运行的线程数量小于corePoolSize时，线程池会新建一个线程来执行任务而不是将任务放入队列，如果运行的线程数量大于corePoolSize时，线程池 会优先
 将任务放入队列。
 
 主要有三种队列
 SynchronousQueue
  
  


