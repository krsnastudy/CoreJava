package com.prac.core.jdks.jdk8.predefinedfunctions.unary;

import java.util.function.UnaryOperator;

public class UnaryOperatorEx {

	public static void main(String[] args) {
		int exponent = 6;
		UnaryOperator<Integer> u = i -> (int) Math.pow(i, exponent);
		System.out.println("UnaryOperator: " + u.apply(15));
	}
}
