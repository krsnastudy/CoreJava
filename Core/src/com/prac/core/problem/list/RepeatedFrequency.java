package com.prac.core.problem.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedFrequency {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(5, 1, 1, 1, 4, 4, 7, 7, 3);

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < list.size(); i++) {
			map.merge(list.get(i), 1, Integer::sum);
		}

		System.out.println(map);
		
		map.entrySet().stream()
		.sorted((x, y) -> x.getValue()==y.getValue() ? (y.getKey()-x.getKey()):(y.getValue()-x.getValue()))
		.limit(2)
		.forEach(System.out::println);
	}
}

/*
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. If multiple numbers have the same frequency, then the largest
 * number should be considered first.
 * 
 * Example 1: Input: nums = [5,1,1,1,4,4,7,7,3], k = 2 Output: [1,7]
 * 
 * Example 2: Input: nums = [1], k = 1 Output: [1]
 * 
 */