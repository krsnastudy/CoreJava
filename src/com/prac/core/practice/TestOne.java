package com.prac.core.practice;

import java.util.stream.Stream;

public class TestOne {

	public static void main(String[] args) {
		Stream.iterate(new int[] {1,1}, n -> new int[]{n[1], n[0] + n[1]})
			.limit(10).map(n->n[0]).forEach(System.out::println);
		
		/*
		 * Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]}) .limit(15)
		 * .map(n -> n[0]) .collect(Collectors.toList());
		 */
	}
}
