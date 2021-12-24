package com.prac.core.jdk8.predefinedfunctions.function;

import java.util.function.Function;

public class FunctionExample {

	public static void main(String[] args) {

		Function<String, Integer> f = s -> s.length();
		System.out.println("Length: " + f.apply("RK"));

		String str = "In the JDK's Object class source code, the method annotated by @HotSpotIntrinsicCandidate has a set of efficient implementations in HotSpot. This efficient implementation is based on CPU instructions.";
		Function<String, Integer> fS = st -> st.length() - st.replaceAll(" ", "").length();
		System.out.println("How many spaces Contains : " + fS.apply(str));

		/* andThen & compose are Default function */
		Function<Integer, Integer> f1 = i -> i + i;
		Function<Integer, Integer> f2 = i -> i * i * i;

		System.out.println("Function Apply: Square: " + f1.apply(4));
		System.out.println("Function Apply: Cube: " + f2.apply(8));

		System.out.println("Function Chaining (andThen): " + f1.andThen(f2).apply(4)); // f1 andThen f2
		System.out.println("Function Chaining (Compose): " + f1.compose(f2).apply(4)); // f2 first andThen f1 -- Order
																						// difference

		/* Identity is a static function : return same object */
		Function<String, String> f3 = Function.identity();
		System.out.println("Function.identity: " + f3.apply("CVRK"));
	}
}

/*
 * The Function Interface is a part of the java.util.function package which has
 * been introduced since Java 8, to implement functional programming in Java. It
 * represents a function which takes in one argument and produces a result.
 * 
 * apply(T t) – Applies this function to the given argument.
 * 
 * default Function<T,V> andThen(Function<? super R,? extends V> after) –->
 * Returns a composed function that first applies this function to its input,
 * and then applies the after function to the result.
 * 
 * default Function<V,R> compose(Function<? super V,? extends T> before) -->
 * Returns a composed function that first applies the before function to its
 * input, and then applies this function to the result.
 * 
 * static Function<T,T> identity() –-> Returns a function that always returns
 * its input argument.
 * 
 */