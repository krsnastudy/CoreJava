package com.prac.core.problem.list;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstRepeatedNumber {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 7, 2, 1, 6, 8, 1 };

		Map<Integer, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < arr.length; i++) {
			map.merge(arr[i], 1, Integer::sum);
		}

		Map.Entry<Integer, Integer> entry = map.entrySet().stream().filter(n -> n.getValue() > 1).findFirst().get();

		System.out.println("First Repeated Number is " + entry.getKey() + " and its Count is: " + entry.getValue());

		/*
		 * int first = Arrays.stream(arr)
		 * .filter(i->Collections.frequency(Arrays.asList(arr), i)>1)
		 * .peek(System.out::print) .distinct() .findFirst() .getAsInt() ;
		 * System.out.println("First Repeated: "+first);
		 */

	}

}
