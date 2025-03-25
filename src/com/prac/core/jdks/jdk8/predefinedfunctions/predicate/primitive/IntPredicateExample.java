package com.prac.core.jdks.jdk8.predefinedfunctions.predicate.primitive;

import java.util.function.IntPredicate;

public class IntPredicateExample {

	public static void main(String[] args) {
		IntPredicate p = i -> i % 2 == 0;
		System.out.println("IntPredicate " + p.test(52));
	}
}

/***
 * Primitive Type Functional Interfaces specializations of the Java 8 Predicate
 * interface
 ***/
/*
 * IntPredicate LongPredicate DoublePredicate
 */