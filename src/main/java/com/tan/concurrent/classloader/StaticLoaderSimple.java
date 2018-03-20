package com.tan.concurrent.classloader;

public class StaticLoaderSimple extends SuperStaticLoaderSimple{
	   static {
		   System.out.println("sub init");
	   }
	

}

class App {
		public static void main(String[] args) {
			System.out.println(StaticLoaderSimple.m);
		}
	}