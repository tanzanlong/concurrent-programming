package com.tan.concurrent.dcl;

public class VolatileSynBlockLazySingleton {

	private volatile static VolatileSynBlockLazySingleton singleton;

    private VolatileSynBlockLazySingleton(){}
    
    public static synchronized VolatileSynBlockLazySingleton getInstance(){
    	 if(singleton == null){
    	synchronized (VolatileSynBlockLazySingleton.class) {
    		 if(singleton == null){
    	            singleton = new VolatileSynBlockLazySingleton();
    	        }
		}
    	
    	 }
       
        return singleton;
    }

}
