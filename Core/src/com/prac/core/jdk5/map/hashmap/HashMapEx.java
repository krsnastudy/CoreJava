package com.prac.core.jdk5.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapEx {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();

		map.put("Zebra", "One");
		map.put("Krishna", "Five");
		map.put("Venkata", "Three");
		map.put("Cheetirala", "Two");
		map.put("Radha", "Four");

//		map.entrySet().stream().forEach(x -> System.out.println(x.getKey() + " -- " + x.getValue()));
//		map.entrySet().stream().sorted((x,y)->x.getValue().compareTo(y.getValue())).forEach(System.out::println); // Sort by Value
		map.entrySet().stream().sorted((x,y)->x.getKey().compareTo(y.getKey())).forEach(System.out::println); // Sort by Key
		
		System.out.println("");

		Map<String, String> tMap = new TreeMap<>(map);
		tMap.entrySet().stream().forEach(x -> System.out.println(x.getKey() + " -- " + x.getValue()));
	}
}
