package com.prac.core.jdk8.stream;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamEx {

	public static void main(String[] args) {

		Consumer<Integer> consumer = i -> System.out.print(i + " ");

		System.out.print("IntStream.of : ");
//		IntStream.of(2).forEach(System.out::print);\
		IntStream.of(2).forEach(i -> consumer.accept(i));

		// Range
		System.out.print("\nIntStream.range : ");
		IntStream stream = IntStream.range(5, 10);
//		stream.forEach(System.out::print); // 5,6,7,8,9
		stream.forEach(i -> consumer.accept(i));
//        IntStream.range(5, 10).forEach( System.out::print ); 

		// Closed Range
		System.out.print("\nIntStream.rangeClosed : ");
		IntStream closedRangeStream = IntStream.rangeClosed(11, 15);
//		closedRangeStream.forEach(System.out::print); // 11,12,13,14,15
		closedRangeStream.forEach(i -> consumer.accept(i));
//        IntStream.rangeClosed(11, 15).forEach( System.out::print );

		System.out.print("\nIntStream.generate : ");
		IntStream generate = IntStream.generate(() -> {
			return (int) (Math.random() * 100);
		});

//		generate.limit(10).forEach(System.out::println);
//		generate.limit(10).forEach(i -> System.out.print(i + " "));
		generate.limit(10).forEach(i -> consumer.accept(i));

		System.out.print("\nPrint Primes: ");
		IntStream primeStream = IntStream.range(1, 25);
		List<Integer> primes = primeStream.filter(IntStreamEx::isPrime).boxed().collect(Collectors.toList());
//		System.out.println(primes);
		primes.forEach(i -> consumer.accept(i));
	}

	public static boolean isPrime(int i) {
		IntPredicate isDivisible = index -> i % index == 0;
		return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
	}
}

/*
 * https://howtodoinjava.com/java8/intstream-examples/
 * 
 * 
 */