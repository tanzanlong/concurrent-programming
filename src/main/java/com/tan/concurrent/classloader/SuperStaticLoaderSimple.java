package com.tan.concurrent.classloader;

public class SuperStaticLoaderSimple {
   protected static int m=2;
   
   static {
	   System.out.println("super init");
   }
}
