package com.prac.core.jdk8.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedChar {

	public static void main(String[] args) {
		String str = "Java 8 functional programming";
		System.out.println("Given: "+str);
		str = str.toLowerCase().replace(" ", "");
		System.out.println("After: "+str);
		
		Map<Character, Integer> map = new LinkedHashMap<>();
		
		for(Character c : str.toCharArray()) {
			map.merge(c, 1, Integer::sum);
		}
		
		Character nChar = map.entrySet().stream()
			.filter(i->(i.getValue()==1))
			.findFirst().get().getKey()
			;
		
		System.out.println("First Non-Repeated Char: "+nChar);
		
		Character result =  str.chars()      //string stream
//	             .mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i))) //convert to lowercase & then to Character object
				 .mapToObj(c->(char)Character.toLowerCase(c))
	             .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //store in a map with the count
	             .entrySet().stream()
	             .filter(entry -> entry.getValue() == 1L)
	             .map(entry -> entry.getKey())
	             .findFirst().get();
		
		System.out.println("First Non-Repeated Char: "+result);
	}

}
