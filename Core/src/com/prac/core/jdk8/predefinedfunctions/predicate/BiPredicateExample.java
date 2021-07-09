package com.prac.core.jdk8.predefinedfunctions.predicate;

import java.util.function.BiPredicate;

public class BiPredicateExample {

	public static void main(String[] args) {
		BiPredicate<Integer, Integer> bp = (a,b)->(a+b)%2==0;
		System.out.println("BiPredicate: "+bp.test(2,  90));
	}
}