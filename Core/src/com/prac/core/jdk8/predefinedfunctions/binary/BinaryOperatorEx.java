package com.prac.core.jdk8.predefinedfunctions.binary;

import java.util.function.BinaryOperator;

public class BinaryOperatorEx {

	public static void main(String[] args) {
		BinaryOperator<String> b = (x, y)->x+y;
		System.out.println("BinaryOperator: "+b.apply("RadhaKrishna ", "CH V"));
		
		BinaryOperator<Integer> p = (x, y)->(int) Math.pow(x, y);
		System.out.println("BinaryOperator Power: "+p.apply(15, 6));
	}
}