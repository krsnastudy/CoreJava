package com.prac.core.string;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sherlock {

	public static void main(String[] args) {
		String str = "abcabccddee";
		IntStream iStream = str.chars();
		Stream<Character> cStream = iStream.mapToObj(x->(char)x);
		Map<Character, Long> output = cStream.collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
		System.out.println(output);
		
		// Remove Max Count Char
		char maxChar=' ';
		for(Map.Entry<Character, Long> entryMap : output.entrySet()) {
			
			if(maxChar=='\0') {
				maxChar = entryMap.getKey();
			}  
		}
	}

}
