package com.prac.core.jdks.jdk8.handson;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CharsToMaps {

	public static void main(String[] args) {
		String str = "abaaacdezyaxmloef";
		Map<Character, Integer> cMap = getHashMap(str);

		System.out.println("      HashMap: " + getHashMap(str));
		System.out.println("LinkedHashMap: " + getlinkedHashMap(cMap));
		System.out.println("      TreeMap: " + getTreeMap(cMap));
	}

	
	public static Map<Character, Integer> getHashMap(String str) {

		char[] cArr = str.toCharArray();
		Map<Character, Integer> cMap = new HashMap<>();

		for (Character c : cArr) {
			cMap.merge(c, 1, Integer::sum);
		}
//System.out.println(cMap.size());
		return cMap;
	}
	
	public static Map<Character, Integer> getlinkedHashMap(Map<Character, Integer> cMap) {
		return  cMap.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByKey())
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o, LinkedHashMap::new));
	}
	
	public static Map<Character, Integer> getTreeMap(Map<Character, Integer> cMap) {
		return cMap.entrySet()
				.stream()
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> o, TreeMap::new));
	}
}