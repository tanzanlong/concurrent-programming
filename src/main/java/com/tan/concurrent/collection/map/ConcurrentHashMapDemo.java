package com.tan.concurrent.collection.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
 public static void main(String[] args) {
	 Map<String,String> map=new ConcurrentHashMap<String,String>();
	 map.put("open", "true");
}
}
