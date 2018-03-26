package com.tan.concurrent.objsize;
import static com.tan.concurrent.objsize.SizeOfObject.*;  
public class SizeSimple {
	static class A{
        int a;
    }
    static class B{
        int a;
        int b;
    }
    public static void  main(String args[])
    {
        System.out.println(sizeOf(new Integer(1)));
        System.out.println(sizeOf(new A()));
        System.out.println(sizeOf(new B()));
        System.out.println(sizeOf((int)1));
    }
}
