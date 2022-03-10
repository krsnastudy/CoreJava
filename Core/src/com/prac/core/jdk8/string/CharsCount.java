package com.prac.core.jdk8.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CharsCount {

	public static void main(String[] args) {
		String str = new String("Radha Krishna");
		Consumer<Map.Entry<Character, Integer>> consume = i->System.out.print(i+" ");
		Map<Character, Integer> count = new HashMap<>();

		str = str.replaceAll(" ", "").toLowerCase();
		System.out.println("Given String: "+str);

		/* Method 1*/
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);

			if (count.containsKey(c)) {
				int charCount = count.get(c);
				count.put(c, ++charCount);
			} else {
				count.put(c, 1);
			}
		}

		System.out.println("Method1: "+count);

		/* Method 2*/
		count = new HashMap<Character, Integer>();
		for(Character c : str.toCharArray()) {
			count.put(c, count.containsKey(c)?count.get(c)+1:1);
		}
		System.out.println("Method2: "+count);
		
		Map<Character, Integer> freqs = new HashMap<>();
		for (char c : str.toLowerCase().toCharArray()) {
		    freqs.merge(c,                  // key = char
		                1,                  // value to merge
		                Integer::sum);      // counting
		}
		
		System.out.println("Map.merge() : "+freqs);
		
		Map<Character, Integer> frequencies = str.chars().boxed()
		        .collect(Collectors.toMap(
		                // key = char
		                k -> Character.valueOf((char) k.intValue()),
		                v -> 1,         // 1 occurence
		                Integer::sum)); // counting
		System.out.println("\nFrequencies: ");
		
		//Print Alphabetically
//		frequencies.entrySet().stream().sorted((i1, i2)->i1.getKey().compareTo(i2.getKey())).forEach(i->System.out.print(i+" "));
		frequencies.entrySet().stream().sorted((i1, i2)->i1.getKey().compareTo(i2.getKey())).forEach(i->consume.accept(i));
		
		System.out.println("\n \nCollections.frequency Example");
		List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
//		list.stream().filter(i -> Collections.frequency(list, i) > 1).collect(Collectors.toSet()).forEach(System.out::println);;
		list.stream().filter(i->Collections.frequency(list, i)>1).distinct().forEach(System.out::println);
	}
}