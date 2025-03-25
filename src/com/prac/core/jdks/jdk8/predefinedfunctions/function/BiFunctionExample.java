package com.prac.core.jdks.jdk8.predefinedfunctions.function;

import java.util.function.BiFunction;

public class BiFunctionExample {

	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> (a * b);
		System.out.println("Bi-Function: " + biFunction.apply(8, 9));
	}
}
