package com.prac.core.jdk5.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstRepetativeNumber {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 7, 2, 1, 6, 8, 1 };
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			map.merge(arr[i], 1, Integer::sum);
		}

		System.out.println(map.entrySet().stream().filter(i -> i.getValue() > 0).findFirst().get());
	}

}
