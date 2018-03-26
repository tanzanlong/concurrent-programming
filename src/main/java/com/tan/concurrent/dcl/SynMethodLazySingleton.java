package com.tan.concurrent.dcl;

public class SynMethodLazySingleton {

	private static SynMethodLazySingleton singleton;

    private SynMethodLazySingleton(){}
    
    public static synchronized SynMethodLazySingleton getInstance(){
        if(singleton == null){
            singleton = new SynMethodLazySingleton();
        }
        
        return singleton;
    }

}
