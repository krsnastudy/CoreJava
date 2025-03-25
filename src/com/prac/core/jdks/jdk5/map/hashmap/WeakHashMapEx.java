package com.prac.core.jdks.jdk5.map.hashmap;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapEx {

	public static void main(String[] args) {

		Map<String, Integer> wmap = new WeakHashMap<>();
		Integer group1 = 1;
		Integer group2 = 2;
		String text1 = new String("Test1");
		String text2 = new String("Test2");

		wmap.put(text1, group1);
		wmap.put(text2, group2);

		System.out.println("Before: " + wmap);

		text1 = null;
		System.gc();

		System.out.println("After: " + wmap);
	}
}