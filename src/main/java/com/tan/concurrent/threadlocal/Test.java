package com.tan.concurrent.threadlocal;

public class Test {
public static void main(String[] args) {
	   int NCPUS = Runtime.getRuntime().availableProcessors();
	   System.out.println(NCPUS);
}
}
