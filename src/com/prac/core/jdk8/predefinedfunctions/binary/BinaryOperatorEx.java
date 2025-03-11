package com.prac.core.jdk8.predefinedfunctions.binary;

import java.util.function.BinaryOperator;

public class BinaryOperatorEx {

	public static void main(String[] args) {
		BinaryOperator<String> b = (x, y) -> x + y;
		System.out.println("BinaryOperator: " + b.apply("RadhaKrishna ", "CH V"));

		BinaryOperator<Integer> p = (x, y) -> (int) Math.pow(x, y);
		System.out.println("BinaryOperator Power: " + p.apply(15, 6));
	}
}



/*
*
*
*
Functional Interface	Input Type	Output Type	Use Case
BinaryOperator<T>	T, T	T	Operations on two inputs of the same type
Function<T, R>	T	R	Converts one type to another
*
*
* */