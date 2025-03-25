package com.prac.core.jdks.jdk8.stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VowelCounter {
	public static void main(String[] args) {

		LinkedHashMap<Character, Integer> hMap = new LinkedHashMap<>();
		hMap.put('a', 0);
		hMap.put('e', 0);
		hMap.put('i', 0);
		hMap.put('o', 0);
		hMap.put('u', 0);
		Map<Character, Integer> count = new LinkedHashMap<>();
		String str = "A tournament is competetion involving many teams";
		hMap = getVowCount(hMap, str);
//		System.out.println("Count");
//		hMap.forEach((k,v)->System.out.println("Vowel: "+k+" - Count: "+v));

		printVowel(str);

//		System.out.println(isVowel("i"));
	}

	@SuppressWarnings("unlikely-arg-type")
	public static LinkedHashMap<Character, Integer> getCountJDK5(String str) {
		LinkedHashMap<Character, Integer> count = new LinkedHashMap<>();
//		char[] cArr = str.toCharArray();
		str = str.replace(" ", "").toLowerCase();
		System.out.println(str);
		for (int i = 0; i < str.length(); i++) {
//			System.out.print(str.charAt(i));
			for (Vowel v : Vowel.values()) {
				if ((str.charAt(i) + "").equals(v.name())) {
//				 System.out.println(str.charAt(i)+"-"+v.name());
					System.out.println(count);
					if (count.containsKey(v.name())) {
//					 System.out.println(str.charAt(i)+"-"+v.name()+"Inside");	
						// Integer cnt = count.get(v.name())+1;
						int cnt = count.get(v.name());
						count.put(str.charAt(i), ++cnt);
					} else {
						System.out.println(str.charAt(i) + "-" + v.name() + " else");
						count.put(str.charAt(i), 1);
					}
				}
			}
		}

		return count;
	}

	public static LinkedHashMap<Character, Integer> getVowCount(LinkedHashMap<Character, Integer> hMap, String str) {
		str = str.replace(" ", "").toLowerCase();
		System.out.println(str);

		for (int i = 0; i < str.length(); i++) {
			if (hMap.containsKey(str.charAt(i))) {
				int count = hMap.get(str.charAt(i));
				hMap.put(str.charAt(i), ++count);
			}
		}

		return hMap;
	}

	public static void printVowel(String str) {
		List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
		str = str.replace(" ", "").toLowerCase();
		System.out.println("printVowel");
		String[] sArr = str.split("");

		List<String> vList = Stream.of(sArr)
				.filter(x -> (x.equals("a") || x.equals("e") || x.equals("i") || x.equals("o") || x.equals("u")))
//		.filter(x->isVowel(x))
				.collect(Collectors.toList());
//		.stream()
//		.collect(Collectors.toMap(x->x, Function.identity()))
//		.collect(((HashMap<String,Integer>) Collectors.groupingBy(Function.identity(), Collectors.counting())));
		// .forEach((k,v)->System.out.println(k+"-"+v)));

		System.out.println(vList);

		vList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.forEach((k, v) -> System.out.println("Vowel[" + k + "]: " + v));

		// tmap.put(c, (count == null ? 1 : count + 1));
	}

	public static boolean isVowel(String x) {
		List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
		if (vowels.contains(x + "")) {
			return true;
		}

		return false;
	}

	private Stream<String> vowels(String[] characters) {
		List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
		return Stream.of(characters).filter(vowels::contains);
	}

	/*
	 * public List<Integer> countVowels(String sentence) { return
	 * Arrays.stream(sentence.split(" ")) .map(word -> word.split(""))
	 * .map(this::vowels) .map(vowelsStream ->
	 * vowelsStream.distinct().collect(toList())) .map(List::size)
	 * .collect(toList()); }
	 */
}

enum Vowel {
	a, e, i, o, u;
}