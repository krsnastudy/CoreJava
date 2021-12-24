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
		
		map.entrySet().stream().forEach(x->System.out.println(x.getKey()+" -- "+x.getValue()));
		
		System.out.println("");
		
		Map<String, String> tMap = new TreeMap<>(map);
		tMap.entrySet().stream().forEach(x->System.out.println(x.getKey()+" -- "+x.getValue()));
	}
}
