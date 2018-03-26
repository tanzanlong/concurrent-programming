package com.tan.concurrent.juc;

public class SynchronizedDemo {
	public synchronized void test1(){

    }
    public void test2(){
        synchronized (this){
        	   synchronized (this){

               	
               }
        }
    }
    
    public synchronized void name(){
      this.test1();
    }
}
