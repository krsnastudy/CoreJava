package com.prac.core.problem.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapHCL {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Map<String, LinkedHashMap<Integer, String>> map = new LinkedHashMap<>();
		
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
		
		lhm.put(1, "One");
		lhm.put(2, "Two");
		lhm.put(3, "One");
		lhm.put(4, "Two");
		lhm.put(5, "Three");
		lhm.put(6, "Four");
		
		map.put("First", lhm);
		map.put("First", lhm);
		map.put("First", lhm);
		
		map.entrySet().stream().forEach(x->System.out.println(x.getKey()+" "+x.getValue()));
		
	}

}
