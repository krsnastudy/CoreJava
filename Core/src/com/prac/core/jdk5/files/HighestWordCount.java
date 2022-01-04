package com.prac.core.jdk5.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HighestWordCount {
	static Map<String, Integer> word = new HashMap<>();

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("D:\\Study\\Coding\\files\\sample.txt");
		Scanner sc = new Scanner(file);
		int topCount = 5;

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (!line.isEmpty()) {
				addWordsToMap(line);
			}
		}

		/** Sorting Using Map Values **/
		System.out.println("Sorted In Map<String, Integer> byValue ");
		word.entrySet().stream()
		               .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
		               .limit(topCount)
		               .forEach(System.out::println);

		/* Take to a new List All Entries and sorting **/
		System.out.println("\nSorted In List<Entry<String, Integer>> by Entry.Value ");
//		List<Entry<String, Integer>> sortedList = 
		word.entrySet().stream()
		        .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
		        .limit(topCount)
				.collect(Collectors.toList())
				.forEach(System.out::println);

//		sortedList.sort((a,b)->b.getValue().compareTo(a.getValue()));
//		sortedList = sortedList.stream().limit(topCount).collect(Collectors.toList());
//		sortedList.forEach(System.out::println);

	}// pvsm

	public static void addWordsToMap(String sc) {
		sc = sc.replace("\t", "");
		sc = sc.replace("  ", "");
		String[] strArray = sc.split(" ");
		for (String s : strArray) {
			String key = s.trim();
			if (word.containsKey(key)) {
				word.put(key, word.get(key) + 1);
			} else {
				word.put(key, 1);
			}
		}
	}
}