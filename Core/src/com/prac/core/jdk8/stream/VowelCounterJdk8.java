package com.prac.core.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VowelCounterJdk8 {

	public static void main(String[] args) {
		String str = "A tournament is competetion involving many teams";
		printVowel(str);

//		str.chars().forEach(y->System.out.println(y));
	}

	public static void printVowel(String str) {
		str = str.replace(" ", "").toLowerCase();
		System.out.println("Input: " + str);
		String[] sArr = str.split("");

		Map<String, Long> vMap = Stream.of(sArr)
//		.filter(x->(x.equals("a")||x.equals("e")||x.equals("i")||x.equals("o")||x.equals("u")))
//		.peek(System.out::print)
				.filter(x -> isVowel(x)).collect(Collectors.toList()).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		// .forEach((k,v)->System.out.println("Vowel["+k+"]: "+v));

		System.out.println("String Array: " + vMap);

//		Arrays.asList(sArr).stream().collect(Collectors.joining(",","[","]"));

		Map<Character, Long> cMap = str.chars()
				.mapToObj(item -> (char) item)
				.filter(x -> (
						 (x + "").equals("a") || (x + "").equals("e") ||
						 (x + "").equals("i") || (x + "").equals("o") ||
						 (x + "").equals("u")
						)
					)
//		      .collect(Collectors.toList())
//		      .stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println("Character Array: " + cMap);
	}

	public static boolean isVowel(String x) {
		List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
		if (vowels.contains(x + "")) {
			return true;
		}
		return false;
	}
}
