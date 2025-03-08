package com.prac.core.practice;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestOne {

	public static void main(String[] args) {

		Consumer<String> print = System.out::println;

		System.out.println("Consumer Example ");
		Consumer<String> consumer = str -> System.out.println(str.toUpperCase());
		consumer.accept("krsna");

		System.out.println("\nFunction Example ");
		Function<Double, Double> square = d -> d * d;
		Function<Double, Double> cube = d -> d * d * d;
		System.out.println("andThen: "+square.andThen(cube).apply(2.0));
		System.out.println("compose: "+square.compose(cube).apply(3.0));

		System.out.println("\nPredicate Example ");
		Predicate<String> predicate = str -> str.length()>0;
		System.out.println(predicate.test("krsna"));

		System.out.println("\nSupplier Example ");
		Supplier<List<Integer>> supplier = () -> IntStream.range(0, 5).boxed().collect(Collectors.toList());
		System.out.println(supplier.get());

	}
}