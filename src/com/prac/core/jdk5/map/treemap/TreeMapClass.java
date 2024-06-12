package com.prac.core.jdk5.map.treemap;

import java.util.TreeMap;

public class TreeMapClass {

	public static void main(String[] args) {
		TreeMap<Integer, String> tMap = new TreeMap<>();

		tMap.put(5, "Five");
		tMap.put(1, "One");
		tMap.put(4, "Four");
		tMap.put(2, "Two");
		tMap.put(3, "Three");
		
		System.out.println(tMap);
		tMap.forEach((k,v)->System.out.println("key: "+k+" & value: "+v));
		System.out.println(tMap.headMap(3));
		System.out.println(tMap.tailMap(2));
		
	}

}
