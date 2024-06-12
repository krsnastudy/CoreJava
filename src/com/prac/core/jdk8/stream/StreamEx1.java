package com.prac.core.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamEx1 {

	public static void main(String[] args) {

		IntStream.range(0, 10).filter(i -> (i % 2 == 1)).forEach(y -> System.out.print(y + " "));
		System.out.println();

		List<String> letters1 = Arrays.asList("a", "b");
		List<String> letters2 = Arrays.asList("b", "c", "d");
		List<String> letters3 = Arrays.asList("e", "f");
		List<List<String>> listOfLetters = Arrays.asList(letters1, letters2, letters3);

		List<String> flatList = listOfLetters.stream().flatMap(List::stream).collect(Collectors.toList());

		flatList.forEach(x -> System.out.print(x + " "));

		System.out.println();
		List<Integer> primes = IntStream.rangeClosed(2, 100)
										.filter(n -> isPrime(n))
										//.filter(n->{if(n<=2){return 2;}else{})
										.boxed()
										.collect(Collectors.toList());

		System.out.println(primes);
	}

	static boolean isPrime(int number) {
		if (number <= 2)
			return number == 2;
		else
			return (number % 2) != 0 && IntStream.rangeClosed(3, (int) Math.sqrt(number)).filter(n -> n % 2 != 0)
					.noneMatch(n -> (number % n == 0));
	}

}
