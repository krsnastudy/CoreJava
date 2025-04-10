package com.prac.core.jdks.jdk8.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseIndividualWord {

	public static void main(String[] args) {

		String str = "This is an Apple";
		
		String revStr = Arrays.asList(str.split(" ")).stream()
				.map(s->new StringBuffer(s).reverse())
				.collect(Collectors.joining(" "));
		
		System.out.println("Actual  String: "+str);
		System.out.println("Reverse String: "+revStr);
//		System.out.println("Reverse Entire String: "+ new StringBuffer(revStr).reverse());


		String revWords = Arrays.stream(str.split("\\s+"))
				.reduce((a, b) -> b + " " + a)
				.orElse(" ");

		System.out.println(revWords);
	}

}
