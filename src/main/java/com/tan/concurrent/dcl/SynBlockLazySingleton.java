package com.tan.concurrent.dcl;

public class SynBlockLazySingleton {

	private static SynBlockLazySingleton singleton;

    private SynBlockLazySingleton(){}
    
    public static synchronized SynBlockLazySingleton getInstance(){
    	 if(singleton == null){
    	synchronized (SynBlockLazySingleton.class) {
    		 if(singleton == null){
    	            singleton = new SynBlockLazySingleton();
    	        }
		}
    	
    	 }
       
        return singleton;
    }

}
