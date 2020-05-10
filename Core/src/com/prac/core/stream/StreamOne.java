package com.prac.core.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamOne {

	public static void main(String[] args) {
		
	}
	public static Map<String, String> arrayToMap(String[] arrayOfString) {
	    return Arrays.asList(arrayOfString)
	      .stream()
	      .map(str -> str.split(":"))
	      //.collect(toMap(str -> str[0], str -> str[1]));
	      .collect(Collectors.toMap(str -> str[0], str -> str[1]));
	}
}
