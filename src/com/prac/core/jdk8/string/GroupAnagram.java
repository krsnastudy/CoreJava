package com.prac.core.jdk8.string;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.*;

public class GroupAnagram {

	// Function to group anagrams from a given list of words
	public static Set<Set<String>> groupAnagrams(List<String> words) {
		// a set to store anagrams
		Set<Set<String>> anagrams = new HashSet<>();

		// base case
		if (words == null) {
			return anagrams;
		}

		// sort each word on the list
		List<String> list = words.stream()
					.map(s -> Stream.of(s.split(""))
					.sorted()
					.collect(Collectors.joining()))
					.collect(Collectors.toList());
		
		System.out.println("Sorted List: "+list);

		// construct a map where the key is each sorted word,
		// and value is a list of indices where it is present
		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			map.putIfAbsent(list.get(i), new ArrayList<>());
			map.get(list.get(i)).add(i);
		}

		System.out.println("Map: "+map);
		
		// traverse the map and read indices for each sorted key.
		// The anagrams are present in the actual list at those indices
		for (var entry : map.entrySet()) {
			Set<String> collection = 
					entry.getValue()
					.stream()
					.map(i -> words.get(i))
					.collect(Collectors.toSet());
			
			if (collection.size() > 1) {
				anagrams.add(collection);
			}
		}

		return anagrams;
	}
	
	public static String sortString(String str) {
		char[] charArr = str.toCharArray();
		Arrays.sort(charArr);
		return String.valueOf(charArr);
	}

	public static Map<String, List<String>> groupAnagrams_JDK5(List<String> words){
		Map<String, List<String>> hMap = new HashMap<>();
		
		for(int i=0; i<words.size(); i++) {
			List<String> keyList = new ArrayList<>();
			String keyString = sortString(words.get(i));
			String valueString = words.get(i);
			
			if(!hMap.containsKey(keyString)) {
				keyList = new ArrayList<>();
				keyList.add(valueString);
				hMap.put(keyString, keyList);
			}else {
				keyList = hMap.get(keyString);
				keyList.add(valueString);
				hMap.put(keyString, keyList);
			}
		}
		
		return hMap;
	}
	
	public static Map<String, List<String>> groupAnagrams_JDK8(List<String> words){
		return words.stream().collect(Collectors.groupingBy(w -> sortString(w)));
	}
	
	public static void main(String[] args) {
		// list of words
		List<String> words = Arrays.asList("CARS", "REPAID", "DUES", "NOSE", "SIGNED", "LANE", "PAIRED", "ARCS", "GRAB",
				"USED", "ONES", "BRAG", "SUED", "LEAN", "SCAR", "DESIGN");
		
		System.out.println("Given List: "+words);
		
		Set<Set<String>> anagrams = groupAnagrams(words);
		System.out.println("Anagrams Using Set: "+anagrams);
//		for (Set<String> anagram : anagrams) {
//			System.out.println(anagram);
//		}
//		
		
		/***************************/
		 List<String> words2 = Arrays.asList("pool", "loop", "stream", "arc",
			        "odor", "car", "rood", "meats", "fires", "fries",
			        "night", "thing", "mates", "teams");
		
		/***** JDK5 Logic *******/
		 Map<String, List<String>> jdk5Map = new HashMap<>();
		 jdk5Map = groupAnagrams_JDK5(words2);
		 System.out.println("\nGroup Anagrams JDK5\n"+jdk5Map);
		 
		 /***** JDK8 Logic *******/
		 Map<String, List<String>> jdk8Map = new HashMap<>();
		 jdk8Map = groupAnagrams_JDK8(words2);
		 System.out.println("\nGroup Anagrams JDK8\n"+jdk8Map);
		 
		
	}//main
}//GroupAnagram

/*
https://www.techiedelight.com/group-anagrams-together-given-list-words/
 */
