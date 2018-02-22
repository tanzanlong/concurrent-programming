package com.tan.concurrent.collection.blockingQueue;

import java.util.Comparator;

public class StringComparator implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		if(arg0.hashCode()>arg1.hashCode()){
			return -1;
		}else if(arg0.hashCode()==arg1.hashCode()){
			return 0;
		}else{
			return 1;
		}
	}

}
