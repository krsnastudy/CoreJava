package com.prac.core.jdk8.string;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.var;

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

	public static void main(String[] args) {
		// list of words
		List<String> words = Arrays.asList("CARS", "REPAID", "DUES", "NOSE", "SIGNED", "LANE", "PAIRED", "ARCS", "GRAB",
				"USED", "ONES", "BRAG", "SUED", "LEAN", "SCAR", "DESIGN");
		
		System.out.println("Given List: "+words);
		
		Set<Set<String>> anagrams = groupAnagrams(words);
		for (Set<String> anagram : anagrams) {
			System.out.println(anagram);
		}
	}
}

/*
https://www.techiedelight.com/group-anagrams-together-given-list-words/
 */
