package com.prac.core.jdk8.predefinedfunctions.unary;

import java.util.function.UnaryOperator;

public class UnaryOperatorEx {

	public static void main(String[] args) {
		UnaryOperator<Integer> u = i -> (int) Math.pow(5, 5);
		System.out.println("UnaryOperator: "+u.apply(5));
	}
}
