package com.prac.core.jdk8.predefinedfunctions.function.primitive;

import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.LongFunction;
import java.util.function.LongToIntFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class IntFunctionExample {

	public static void main(String[] args) {

		System.out.println("Primitive Function Functional Interface (input argument)");
		IntFunction<Integer> iFunction = i -> i * i;
		System.out.println("IntFunction: " + iFunction.apply(5));

		DoubleFunction<Double> dFunction = d -> d - 0;
		System.out.println("DoubleFunction: " + dFunction.apply(2));

		LongFunction<Long> lFunction = l -> l * 2;
		System.out.println("LongFunction: " + lFunction.apply(2));

		System.out.println("\nPrimitive Function Functional Interface (return-type)");
		ToIntFunction<Integer> toInt = i -> i * i;
		System.out.println("ToIntFunction Square of number 5 is " + toInt.applyAsInt(5));

		ToLongFunction<Integer> toLong = i -> i * 1024;
		System.out.println("ToLongFunction 5 * 1024 = " + toLong.applyAsLong(5));

		ToDoubleFunction<Integer> toDouble = i -> i - 0.5;
		System.out.println("ToDoubleFunction After discount, for 5 = " + toDouble.applyAsDouble(5));

		System.out.println("\nPrimitive Function Functional Interface (conversion)");
		IntToLongFunction ilf = i -> i * 2048;
		System.out.println("IntToLongFunction 1. 5 * 2048 = " + ilf.applyAsLong(5));

		LongToIntFunction ltf = i -> (int) i * 3;
		System.out.println("LongToIntFunction 2 * 3 = " + ltf.applyAsInt(6));
	}
}

/*
 * ---- Input Type Primitives Primitive Function Functional Interface (input
 * argument) : This is very similar to Function Functional Interface but it
 * always accepts 1 input argument of type primitive-type like int, long and
 * double, whereas Function allows to accepts any data-type and return result in
 * any data-type
 * 
 * Performance-wise primitive Function is much faster compared to Function<T, R>
 * There are lot of conversion happening for auto-boxing & auto-unboxing for
 * converting primitive-type to wrapper-type and again wrapper-type to
 * primitive-type and so on
 * 
 * To avoid unnecessary conversion between primitive-type to wrapper-type and
 * vice-versa, primitive-type specific Function Functional Interface for
 * conversion introduced in Java 1.8 version as listed below,
 * 
 * IntFunction LongFunction DoubleFunction
 */

/*
 * ------ Return type Primitives ------------- Primitive Function Functional
 * Interface (return-type) : This is very similar to Function Functional
 * Interface where it accepts 1 input argument of any data-type but return-type
 * must be primitive-type like int, long and double, etc, whereas Function
 * allows to accepts any data-type and return result in any data-type
 * 
 * Performance-wise primitive Function is much faster compared to Function<T, R>
 * There are lot of conversion happening for auto-boxing & auto-unboxing for
 * converting primitive-type to wrapper-type and again wrapper-type to
 * primitive-type and so on
 * 
 * To avoid unnecessary conversion between primitive-type to wrapper-type and
 * vice-versa, primitive-type specific Function Functional Interface for
 * conversion introduced in Java 1.8 version as listed below,
 * 
 * ToIntFunction ToLongFunction ToDoubleFunction
 * 
 */

/*
 * Primitive Function Functional Interface (conversion)
 * 
 * This is very similar to Function Functional Interface but here both input
 * argument type as well as return-type is defined as primitive-types like int,
 * long and double, etc, whereas Function allows to accepts any data-type and
 * return result in any data-type
 * 
 * Performance-wise primitive Function is much faster compared to Function<T, R>
 * There are lot of conversion happening for auto-boxing & auto-unboxing for
 * converting primitive-type to wrapper-type and again wrapper-type to
 * primitive-type and so on
 * 
 * To avoid unnecessary conversion between primitive-type to wrapper-type and
 * vice-versa, primitive-type specific Function Functional Interface for
 * conversion introduced in Java 1.8 version as listed below,
 * 
 * IntToLongFunction IntToDoubleFunction LongToIntFunction LongToDoubleFunction
 * DoubleToIntFunction DoubleToLongFunction
 */