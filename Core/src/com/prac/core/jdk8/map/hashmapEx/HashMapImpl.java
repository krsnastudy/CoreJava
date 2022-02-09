package com.prac.core.jdk8.map.hashmapEx;

import java.util.Map;

public class HashMapImpl {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMapTest();
		map.put(1, null);

		System.out.println(map);
	}

}
