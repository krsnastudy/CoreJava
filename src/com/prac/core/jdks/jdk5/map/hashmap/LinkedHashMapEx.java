package com.prac.core.jdks.jdk5.map.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.prac.core.jdks.jdk8.util.CoreUtil;

public class LinkedHashMapEx {

	public static void main(String[] args) {
		int strLen = 5;
		Map<Integer, String> hMap = new HashMap<>(4);
		Map<Integer, String> lhMap = new LinkedHashMap<>(4);

		for (int i = 0; i < 8; i++) {
			int k = CoreUtil.getRandomInt();
			String v = CoreUtil.getRandomString(strLen);
			System.out.println("Iteration# " + i + " --> [" + k + ", " + v + "]");

			hMap.put(k, v);
			lhMap.put(k, v);
		}

		hMap.put(null, "NullValue");
		lhMap.put(null, "NullValue");

		System.out.println("\nHashMap Entries: " + hMap);
		System.out.println("LinkedHashMap Entries: " + lhMap);
		
	}

}
