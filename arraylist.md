
list的可变数组的实现。
自动扩容。
非线程安全，可以通过 List list = Collections.synchronizedList(new ArrayList(...))来定义线程安全的。

实现了迭代，迭代具有fail-fast机制。

fail-fast具体实现是 list会维护一个modcount 迭代器初始化的时候会将list当前的modcount拷贝出来作为expectedModCount，当modcount不等于expectedModCount，抛出ConcurrentModificationException异常。

自动扩容机制导致它在添加元素时如果容量不够会触发扩容，这就会导致性能损耗。所以我们可以尽可能的在知道目标数量的情况下给它一个初始化，避免它的扩容。比如：
List<String> list=new ArrayList<String>(100);

在modcount等于expectedModCount的前提下，调用迭代器的remove方法不会抛出ConcurrentModificationException异常。

 默认10，扩容倍数 int newCapacity = oldCapacity + (oldCapacity >> 1);
 
 
 fail-fast和fail—safe有什么区别？
一：快速失败（fail—fast）
          在用迭代器遍历一个集合对象时，如果遍历过程中对集合对象的内容进行了修改（增加、删除、修改），则会抛出Concurrent Modification Exception。
          原理：迭代器在遍历时直接访问集合中的内容，并且在遍历过程中使用一个 modCount 变量。集合在被遍历期间如果内容发生变化，就会改变modCount的值。每当迭代器使用hashNext()/next()遍历下一个元素之前，都会检测modCount变量是否为expectedmodCount值，是的话就返回遍历；否则抛出异常，终止遍历。
      注意：这里异常的抛出条件是检测到 modCount！=expectedmodCount 这个条件。如果集合发生变化时修改modCount值刚好又设置为了expectedmodCount值，则异常不会抛出。因此，不能依赖于这个异常是否抛出而进行并发操作的编程，这个异常只建议用于检测并发修改的bug。
      场景：java.util包下的集合类都是快速失败的，不能在多线程下发生并发修改（迭代过程中被修改）。
    二：安全失败（fail—safe）
      采用安全失败机制的集合容器，在遍历时不是直接在集合内容上访问的，而是先复制原有集合内容，在拷贝的集合上进行遍历。
      原理：由于迭代时是对原集合的拷贝进行遍历，所以在遍历过程中对原集合所作的修改并不能被迭代器检测到，所以不会触发Concurrent Modification Exception。
      缺点：基于拷贝内容的优点是避免了Concurrent Modification Exception，但同样地，迭代器并不能访问到修改后的内容，即：迭代器遍历的是开始遍历那一刻拿到的集合拷贝，在遍历期间原集合发生的修改迭代器是不知道的。





参考：  http://cmsblogs.com/