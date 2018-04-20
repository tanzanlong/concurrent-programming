
哈希算法：是一种将任意内容的输入转换成相同长度输出的加密方式，其输出被称为哈希值。

哈希表：根据设定的哈希函数H(key)和处理冲突方法将一组关键字映象到一个有限的地址区间上，并以关键字在地址区间中的象作为记录在表中的存储位置，这种表称为哈希表或散列，所得存储位置称为哈希地址或散列地址。

为什么需要ConcurrentHashMap？

1.因为多线程环境下，使用Hashmap进行put操作会引起死循环，导致CPU利用率接近100%，所以在并发情况下不能使用HashMap。

2.效率低下的HashTable容器;HashTable容器使用synchronized来保证线程安全，但在线程竞争激烈的情况下HashTable的效率非常低下。因为当一个线程访问HashTable的同步方法时，其他线程访问HashTable的同步方法时，可能会进入阻塞或轮询状态。如线程1使用put进行添加元素，线程2不但不能使用put方法添加元素，并且也不能使用get方法来获取元素，所以竞争越激烈效率越低。

3.Collections.synchronizedMap(hashMap)效率低下;


1. 数据结构

在1.8版本以前，ConcurrentHashMap采用分段锁的概念，使锁更加细化，但是1.8已经改变了这种思路，而是利用CAS+Synchronized来保证并发更新的安全，当然底层采用数组+链表+红黑树的存储结构。

 分段锁：http://ifeve.com/concurrenthashmap/
 
 ConcurrentHashMap是由Segment数组结构和HashEntry数组结构组成。Segment是一种可重入锁ReentrantLock，在ConcurrentHashMap里扮演锁的角色，HashEntry则用于存储键值对数据。一个ConcurrentHashMap里包含一个Segment数组，Segment的结构和HashMap类似，是一种数组和链表结构， 一个Segment里包含一个HashEntry数组，每个HashEntry是一个链表结构的元素， 每个Segment守护者一个HashEntry数组里的元素,当对HashEntry数组的数据进行修改时，必须首先获得它对应的Segment锁。
 
 put和remove操作发生的同时，读取操作不会被阻塞，读取操作会读取到最新更新操作完成后的结果集。聚合操作，像putAll和clear可能会获得insert或者remov掉一部分后的结果集。类似的，iterator/enumeration操作获得的结果集也是某个时间点或者iterator/enumeration创建时的结果集。但是它不会抛 ConcurrentModificationException异常。但是iterators被设计为单线程访问的。你需要选择一个合适的concurrencyLevel，太大会导致空间浪费，太小会导致线程对资源的竞争。不过一个数据级下的差异不会有太大影响。如果确定只有一个线程做更新操作，其他线程都是读操作，我们推荐把这个值设为1，对hash table的扩容操作都是相对耗时的，所以最好我们对实际情况做一个评估，在构造器里面给一个评估值。不允许null作为key或者value。
  
  获取操作put解读：
  
  
  

  数组+链表+红黑树 ：http://cmsblogs.com/?p=2283
  
  
  
  
 ConcurrentHashMap的弱一致 http://ifeve.com/concurrenthashmap-weakly-consistent/？
 
 ConcurrentHashMap迭代器为什么不抛出ConcurrentModificationException异常，即fail-fast机制？
 
 ConcurrentHashMap扩容机制？
 
 ConcurrentHashMap优化？
 
 


























http://ifeve.com/concurrenthashmap/