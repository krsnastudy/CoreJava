package com.prac.core.jdk5.string;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestWordPrintDesc {
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("D:\\Coding\\files\\sample1.txt");
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (!line.isEmpty()) {
				addWordsToSet(line);
			}
		}

		Map<String, Integer> map = set.stream().collect(Collectors.toMap(x -> x, y -> y.length()));
		System.out.println("Given Data: " + set);
		System.out.println("Given Data In Map: " + map);

//		Set<String> sortSet = set.stream().sorted((a,b)->b.length()-a.length()).collect(Collectors.toSet());
//		System.out.println(sortSet);
		System.out.println();

		map.entrySet().stream().sorted((x, y) -> y.getValue() - x.getValue()).limit(5).forEach(System.out::println);
	}// pvsm

	private static void addWordsToSet(String line) {
		String[] sArray = line.split(" ");
		Arrays.stream(sArray).forEach(x -> set.add(x));
	}
}