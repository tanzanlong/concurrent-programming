package com.tan.concurrent.threadpool;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**https://www.jianshu.com/p/3527c91f542d
 * @author Administrator
 *
 */
public class SettlementThreadPoolDemo extends AbstractExecutorService{

	
	private final BlockingQueue<Runnable> workQueue;
	
	
	final ReentrantLock mainlock=new ReentrantLock();
	
	/**
	 * 可以存活的最小线程数
	 */
	private volatile int corePoolSize;
	
	
    /**
     * 最大线程数
     */
    private volatile int maximumPoolSize;
	

	/**
	 * 为了能在一个int为上表示线程数和状态 我们限定workerCount在(2^29)-1 (about 500 million)，而不是(2^31)-1 (2
     * billion)
	 */
	private static final int COUNT_AND_STATE_BITS = Integer.SIZE - 3;
	
	
	/**
	 * 容量 2的29次方 -1
	 */
	private static final int CAPACITY   = (1 << COUNT_AND_STATE_BITS) - 1;
	
	
	/**
	 *  二进制表示 为  ：1010  0000000000000000000000000000  最高位为符号位 
	 */
	private static final int RUNNING    = -1 << COUNT_AND_STATE_BITS;
	
    private static final int SHUTDOWN   =  0 << COUNT_AND_STATE_BITS;
    private static final int STOP       =  1 << COUNT_AND_STATE_BITS;
    private static final int TIDYING    =  2 << COUNT_AND_STATE_BITS;
    private static final int TERMINATED =  3 << COUNT_AND_STATE_BITS;

	
	
	
	/**位运算 与获得工作线程数  例如 ：
	 * 
	 * 
	 * 
	CAPACITY   0000  1111111111111111111111111111

     c         1111  0000000000000000000000000001
          去掉标识状态位的高位  获得真实线程数的低位 用1到28位表示线程数
	 * 
	 * @param c
	 * @return
	 */
	private static int workerCountOf(int c)  { return c & CAPACITY; }
	
    /**
     * 
     	CAPACITY   1111  0000000000000000000000000000

         c         1111  0000000000000000000000000001
          去掉标识线程数的低位  获得高位的状态位  用29到31位表示线程数
     * @param c
     * @return
     */
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
	
	/**
	 * 状态初始化为 RUNNING 数量初始化为 0
	 */
	private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
	
	
	
	//private  boolean core=false;
	
	
	
	private static int ctlOf(int rs, int wc) { return rs | wc; }
	
	/**
	 * 
	 */
	 private volatile ThreadFactory threadFactory;
	 
	  private volatile long keepAliveTime;
	  
	  private volatile boolean allowCoreThreadTimeOut;
	  
	  private final HashSet<Worker> workers = new HashSet<Worker>();
	  
	  private int largestPoolSize;
	
    /**递增工作线程数
     * @param expect
     * @return
     */
    private boolean compareAndIncrementWorkerCount(int expect) {
        return ctl.compareAndSet(expect, expect + 1);
    }
	
	
	public SettlementThreadPoolDemo(BlockingQueue<Runnable> workQueue){
		this.workQueue=workQueue;
	}


    private static boolean runStateLessThan(int c, int s) {
        return c < s;
    }

    private static boolean runStateAtLeast(int c, int s) {
        return c >= s;
    }

	@Override
	public boolean awaitTermination(long arg0, TimeUnit arg1)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isShutdown() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isTerminated() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Runnable> shutdownNow() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void execute(Runnable task) {
		
		if(task==null){
			throw new NullPointerException();
		}
		
		
		int c=ctl.get();
		
		/**
		 *如果正在运行的线程数小于corePoolSize,新建一个线程来执行这个任务
		 */
		if(workerCountOf(c)<corePoolSize){ 
			
		}
		
	}
	
	
	private boolean addWorker(Runnable firstTask, boolean core) {
        /**
         * 返回重新执行起点标识
         */
		retry: 
			
   for (;;) {
			int c = ctl.get();
			int rs = runStateOf(c);

			/**
			 * 获取当前线程池的状态，如果是STOP，TIDYING,TERMINATED状态的话，则会返回false，如果现在状态是SHUTDOWN，但是firstTask不为空或者workQueue为空的话，那么直接返回false。
			 */
	           if (rs >= SHUTDOWN &&
	                   ! (rs == SHUTDOWN &&
	                      firstTask == null &&
	                      ! workQueue.isEmpty()))
	                   return false;
	           for (;;) {
	        	   
	        	   int workCount=workerCountOf(c);
	        	   
	        	   if(workCount>CAPACITY||workCount>(core?corePoolSize:maximumPoolSize)){
	        		   return false;
	        	   }
	        	   
	        	   if(compareAndIncrementWorkerCount(c)){
	        		   break retry;
	        	   }
	        	   
	        	   c = ctl.get();
	        	   if(runStateOf(c)!=rs){
	        		   continue retry;
	        	   }
	        	   
	           }
	           
	           

		//	return false;
		}

    boolean workerStarted = false;
    boolean workerAdded = false;
	
    Worker w=null;
    
    w=new Worker(firstTask);
    
    final Thread t=w.thread;
    
    if(t!=null){
    	
    	final ReentrantLock mainLock=this.mainlock;
    	mainLock.lock();
    	 try {
             // Recheck while holding lock.
             // Back out on ThreadFactory failure or if
             // shut down before lock acquired.
             int rs = runStateOf(ctl.get());

             if (rs < SHUTDOWN ||
                 (rs == SHUTDOWN && firstTask == null)) {
                 if (t.isAlive()) // precheck that t is startable
                     throw new IllegalThreadStateException();
                 workers.add(w);
                 int s = workers.size();
                 if (s > largestPoolSize)
                     largestPoolSize = s;
                 workerAdded = true;
             }
         } finally {
             mainLock.unlock();
         }
         if (workerAdded) {
             t.start();
             workerStarted = true;
         }
         
    }
	return workerAdded;
    
	}
	
	/**主要用来控制线程的中断状态。
	 * @author Administrator
	 *
	 */
	private final class Worker extends AbstractQueuedSynchronizer implements
			Runnable {

		final Thread thread;
		
		Runnable firstTask;
		
		volatile long completedTasks;
		
		Worker(Runnable firstTask){
			setState(-1);
			this.firstTask=firstTask;
			this.thread=getThreadFactory().newThread(this);
		}
		
		@Override
		public void run() {
        
		}

		protected boolean isHeldExclusively() {
			/**
			 * 0 代表没有持有锁的状态
			 * 1 代表持有锁的状态
			 */
			return getState() != 0;
		}
		
		protected boolean tryAcquire(int unused) {
			if(compareAndSetState(0, 1)){
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return  false;
		}
		
		protected boolean tryRealse(int unused) {
			 setExclusiveOwnerThread(null);
			 setState(0);
			 return true;
		}
		
		
		public void lock(){
			acquire(1);
		}
       
		public boolean tryLock(){
			return tryAcquire(1);
		}
		
		public void unlock(){
			release(1);
		}
		
		public void isLocked(){
			isHeldExclusively();
		}
		
		
		 void interruptIfStarted(){
			Thread t;
			if(getState()>=0&&(t=thread)!=null&&!t.isInterrupted()){
				t.interrupt();
			}
		}
		
	}
	
	
	final void runWorker(Worker w) throws InterruptedException{
		
		Thread wt=Thread.currentThread();
		
		Runnable task=w.firstTask;
		
		w.firstTask=null;
		
		w.unlock();
		
		boolean completedAbruptly=true;
		
		while(task!=null || (task=getTask())!=null){
			w.lock();
			/**
			 * 如果线程池已经处于stopping状态 需要确保线程中断标识是处于中断状态
			 * 如果没有线程池处于stopping 状态，需要确保线程处于没有中断的标识。
			 * 
			 */
			  if ((runStateAtLeast(ctl.get(), STOP) ||
	                     (Thread.interrupted() &&
	                      runStateAtLeast(ctl.get(), STOP))) &&
	                    !wt.isInterrupted())
	                    wt.interrupt();
			
			    try {
                    beforeExecute(wt, task);
                    Throwable thrown = null;
                    try {
                        task.run();
                    } catch (RuntimeException x) {
                        thrown = x; throw x;
                    } catch (Error x) {
                        thrown = x; throw x;
                    } catch (Throwable x) {
                        thrown = x; throw new Error(x);
                    } finally {
                        afterExecute(task, thrown);
                    }
                } finally {
                    task = null;
                    w.completedTasks++;
                    w.unlock();
                }
			  
			
		}
	}
	
	 protected void beforeExecute(Thread t, Runnable r) { }
	 
	 protected void afterExecute(Runnable r, Throwable t) { }
	
	 private Runnable getTask() throws InterruptedException {
		 boolean timedOut=false;
		 
		 for (; ;) {
			 int c=ctl.get();
			 int rs= runStateOf(c);
			 
			 if(rs>SHUTDOWN&&(rs>STOP||workQueue.isEmpty())){
				 decrementWorkerCount();
				 return null;
			 }
			 
			 int wc=workerCountOf(c);
			 
			 boolean timed = allowCoreThreadTimeOut || wc > corePoolSize;
			 
			 if(wc>maximumPoolSize&&(wc>1||workQueue.isEmpty())){
				 if(compareAndDecrementWorkerCount(c)){
					 return null;
				 }
				 continue;
			 }
			 
			 
			 Runnable r=timed?workQueue.poll(keepAliveTime,TimeUnit.NANOSECONDS):workQueue.take();
			 
			 if(r!=null){
				 return r;
			 }
			 timedOut=true;
		 }
		 
	 }

	private void decrementWorkerCount() {
		do {
		} while (!compareAndDecrementWorkerCount(ctl.get()));
	}
	
    private boolean compareAndDecrementWorkerCount(int expect) {
        return ctl.compareAndSet(expect, expect - 1);
    }
	
    public ThreadFactory getThreadFactory() {
        return threadFactory;
    }
	
	public static void main(String[] args) {
		 System.out.println(COUNT_AND_STATE_BITS);
		 System.out.println(CAPACITY);
		 System.out.println(0 << COUNT_AND_STATE_BITS);
		 System.out.println(ctlOf(RUNNING, 0));
		 
		 
	}
}
