package com.prac.core.jdk5.map.hashmap;

import java.util.WeakHashMap;

public class WeakMapEx {
	public static void main(String[] args) {
		// Creating WeakHashMap of numbers
		WeakHashMap<String, Integer> numbers = new WeakHashMap<>();

		String two = new String("Two");
		Integer twoValue = 2;
		String four = new String("Four");
		Integer fourValue = 4;

		// Inserting elements
		numbers.put(two, twoValue);
		numbers.put(four, fourValue);
		System.out.println("WeakHashMap: " + numbers);

		// Make the reference null
		two = null;

		// Perform garbage collection
		System.gc();

		System.out.println("WeakHashMap after garbage collection: " + numbers);
	}
}

/*
WeakHashMap

WeakHashMap is an implementation of the Map interface. 
WeakHashMap is almost same as HashMap except in case of WeakHashMap, 
if object is specified as key doesn’t contain any references - 
it is eligible for garbage collection even though it is associated with WeakHashMap. 
i.e Garbage Collector dominates over WeakHashMap.
*/