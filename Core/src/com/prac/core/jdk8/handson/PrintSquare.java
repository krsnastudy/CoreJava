package com.prac.core.jdk8.handson;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.prac.core.jdk8.util.CoreUtil;

public class PrintSquare {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int minRange = 1, maxRange = 100;
		Consumer<Integer> print = x -> System.out.print(x + " ");

		System.out.print("Even Numbers : ");
		IntStream.rangeClosed(minRange, maxRange).filter(i -> (i % 2) == 0).limit(20).boxed()
				.collect(Collectors.toList()).forEach(x -> print.accept(x));

		System.out.print("\nOdd Numbers  : ");
		IntStream.rangeClosed(minRange, maxRange).filter(i -> (i % 2) == 1).limit(20).boxed()
				.collect(Collectors.toList()).forEach(x -> print.accept(x));

		System.out.print("\nSquare Numbers:");
		IntStream.rangeClosed(minRange, maxRange).map(i -> i * i).boxed().limit(20).collect(Collectors.toList())
				.forEach(x -> print.accept(x));

		System.out.print("\nPrime Numbers: ");
		// List<Integer> primes =
		IntStream.rangeClosed(1, maxRange).filter(PrintSquare::isPrime).boxed().collect(Collectors.toList())
				.forEach(x -> print.accept(x));

		/*
		List<Integer> list = CoreUtil.getRandomNumbers(15);
//		Collections.sort(list); // Natural Sort
		list.sort((a,b)->b-a);
		System.out.println("\n"+list);
		
		Integer max = list.stream().distinct().max(Comparator.comparing(Integer::valueOf)).get();
		Integer min = list.stream().distinct().min(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("Max : "+max+" && Min : "+min); */
	}
	
	
	public static boolean isPrime(int i) {
		IntPredicate isDivisible = index -> i % index == 0;
		return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
	}	
} // PrintSquare
