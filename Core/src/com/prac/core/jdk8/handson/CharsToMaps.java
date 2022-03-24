package com.prac.core.jdk8.handson;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CharsToMaps {

	public static void main(String[] args) {
		String str="abaaacdezyaxmloef";
		
		char[] cArr = str.toCharArray();
		Map<Character, Integer> cMap = new HashMap<>();
		
		for(Character c: cArr) {
			cMap.merge(c, 1, Integer::sum);
		}
		
		System.out.println("      HashMap: "+cMap);
		
		Map lhMap = cMap.entrySet().stream()
			.sorted(Map.Entry.comparingByKey())
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o,n)->o, LinkedHashMap::new));
		
		System.out.println("LinkedHashMap: "+lhMap);
		
		Map tMap = cMap.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o,n)->o, TreeMap::new));
		
		System.out.println("      TreeMap: "+tMap);
	}
}
