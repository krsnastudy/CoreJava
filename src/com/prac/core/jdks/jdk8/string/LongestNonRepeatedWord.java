package com.prac.core.jdks.jdk8.string;

import java.util.*;

public class LongestNonRepeatedWord {

	public static void main(String[] args) {

		String str = "If the current character is present in currently considered non repeating character string, then update non repeating character string to start from the next character of previousIndex";
		str = str.replaceAll(",", "");

		StringTokenizer tokens = new StringTokenizer(str, " ");
		Map<Integer, String> hashmap = new HashMap<>();

		while (tokens.hasMoreElements()) {

			String localStr = tokens.nextToken();

			if (isNonRepeated(localStr)) {
				hashmap.put(localStr.length(), localStr);
			}
		}

//		hashmap.entrySet().stream().sorted((a, b) -> (b.getKey() - a.getKey()));
//		hashmap.entrySet().stream().sorted((x, y) -> (y.getValue().length() > x.getValue().length() ? 1 : -1));
		System.out.println("HashMap: " + hashmap);

		Integer maxKey = hashmap.entrySet().stream().max((entry1, entry2) -> entry1.getKey() > entry2.getKey() ? 1 : -1)
				.get().getKey();

		String nonRepeated = hashmap.entrySet()
									.stream()
									.max((a, b) -> a.getKey() > b.getKey() ? 1 : -1)
									.get()
									.getValue();
		System.out.println(hashmap.entrySet().stream().sorted(Comparator.comparing(String::valueOf).reversed()).findFirst().get());
		System.out.println("nonRepeated: " + nonRepeated + " -- Length: " + maxKey);

	}// psvm

	public static boolean isNonRepeated(String str) {

		Set<Character> set = new HashSet<>();

		for (char c : str.toLowerCase().toCharArray()) {
			set.add(c);
		}

		return (str.length() == set.size());
	}

}// LongestNonRepeatedSubstring
