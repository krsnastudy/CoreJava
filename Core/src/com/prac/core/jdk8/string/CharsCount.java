package com.prac.core.jdk8.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CharsCount {

	public static void main(String[] args) {
		String str = new String("Radha Krishna");

		Map<Character, Integer> count = new HashMap<>();

		str = str.replaceAll(" ", "").toLowerCase();
		System.out.println(str);

		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);

			if (count.containsKey(c)) {
				int charCount = count.get(c);
				count.put(c, ++charCount);
			} else {
				count.put(c, 1);
			}
		}

		System.out.println(count);
		
		Map<Character, Integer> freqs = new HashMap<>();
		for (char c : str.toLowerCase().toCharArray()) {
		    freqs.merge(c,                  // key = char
		                1,                  // value to merge
		                Integer::sum);      // counting
		}
		
		System.out.println(freqs);
		
		Map<Character, Integer> frequencies = str.chars().boxed()
		        .collect(Collectors.toMap(
		                // key = char
		                k -> Character.valueOf((char) k.intValue()),
		                v -> 1,         // 1 occurence
		                Integer::sum)); // counting
		System.out.println("Frequencies:\n" + frequencies);
		
		
		List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
//		list.stream().filter(i -> Collections.frequency(list, i) > 1).collect(Collectors.toSet()).forEach(System.out::println);;
		list.stream().filter(i->Collections.frequency(list, i)>1).distinct().forEach(System.out::println);
	}


}
