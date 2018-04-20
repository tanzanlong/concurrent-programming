package com.tan.concurrent.collection.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
 public static void main(String[] args) {
	Map<String,String>treeMap=new TreeMap<String,String>();
	treeMap.put("name", "tan");
	treeMap.get("name");
}
}
