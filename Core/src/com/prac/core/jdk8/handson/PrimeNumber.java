package com.prac.core.jdk8.handson;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeNumber {

	public static void main(String[] args) {

		long count = Stream.iterate(0, n -> n + 1)
				.limit(100)
				.filter(PrimeNumber::isPrimeNumber_Java8)
//				.filter(PrimeNumber::isPrimeNumber_Java5)
				.peek(x -> System.out.format("%s ", x))
				.count();

		System.out.println("\nTotal: " + count);
		
/*
		int number=25;
		IntStream.rangeClosed(2, number/2)
			.peek(x -> System.out.print("[("+x+")-->"+(number % x)+" "+(number % x==0)+"] "))
			.forEach(i -> System.out.print((number % i)+" "));
		
		System.out.println();
*/	
//		System.out.println(12%2==0);
	}

	public static boolean isPrimeNumber_Java8(int number) {
		boolean isPrime = false;

		if (number < 2 && number > 0)
			return isPrime;

		return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
	}
	
	private static boolean isPrimeNumber_Java5(int number) {

        if (number <= 1) return false;    //  1 is not prime and also not composite

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
