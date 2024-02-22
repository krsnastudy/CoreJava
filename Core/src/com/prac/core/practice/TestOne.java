package com.prac.core.practice;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.prac.core.jdk8.handson.PrimeNumber;

public class TestOne {

	public static void main(String[] args) {

		long count = Stream.iterate(0, n -> n + 1)
				.limit(50)
				.filter(PrimeNumber::isPrimeNumber_Java8)
//				.filter(PrimeNumber::isPrimeNumber_Java5)
				.peek(x -> System.out.format("%s ", x))
				.count();
		}
	
	public static boolean isPrime(int n) {
		boolean isPrime = false;

		if (n < 2 && n >= 0)
		return isPrime;
		
		return !IntStream.rangeClosed(2, n / 2).anyMatch(i -> n % i == 0);
	}

}
