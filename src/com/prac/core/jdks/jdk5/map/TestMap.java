package com.prac.core.jdks.jdk5.map;

public class TestMap {

	public static void main(String[] args) {
		OwnMap oMap = new OwnMap();
		oMap.put("1", "One");
		oMap.put("2", "Two");
		oMap.put("3", "Three");
		oMap.put("4", "Four");
		oMap.put("5", "Five");
		
		oMap.printHashMap(oMap);
	}

}
