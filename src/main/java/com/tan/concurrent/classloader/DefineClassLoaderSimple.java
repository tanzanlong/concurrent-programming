package com.tan.concurrent.classloader;

public class DefineClassLoaderSimple {
 public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	 ClassLoader loader=new ClassLoader() {
	};
	Object  obj=loader.loadClass("com.tan.concurrent.classloader.DefineClassLoaderSimple").newInstance();
	
	System.out.println(obj instanceof DefineClassLoaderSimple);
}
}
