package com.prac.core.jdk8.gen.fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("Fibonacci: "+generateFibonacci(15));
	}

	
	public static List<Long> generateFibonacci(int series){
		
		List<Long> list = new ArrayList<>();
		
		list = Stream.iterate(new Long[] {(long) 1, (long) 1}, s->new Long[] {s[1], s[0]+s[1]})
				.limit(series)
				.map(n -> n[0])
				.collect(Collectors.toList())
				;
		
		return list;
	}
}