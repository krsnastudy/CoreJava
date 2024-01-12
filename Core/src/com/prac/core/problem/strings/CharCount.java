package com.prac.core.problem.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CharCount {

	public static void main(String[] args) {
		// Print Character and its count
		String input = "aabbbcccc";
		String output = "a2b3c4";

		Map<Character, Integer> map = new HashMap<>();

		for (Character c : input.toCharArray()) {
			map.merge(c, 1, Integer::sum);
		}

		System.out.println(map);
		map.forEach((x, y) -> System.out.print(x + "" + y));
		System.out.println();

		input.chars().boxed()
				.collect(Collectors.toMap(k -> Character.valueOf((char) k.intValue()), v -> 1, Integer::sum))
				.entrySet()
				.forEach(e -> System.out.print(e.getKey() + "" + e.getValue()));
	}

}
