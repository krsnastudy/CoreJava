package com.prac.core.jdks.jdk8.handson;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SumOfPerfectSquares {

	public static void main(String[] args) {
		int minRange =1;
		int maxRange =100;
		
		Predicate<Integer> perfectSquares = number -> number == (int) Math.sqrt(number) * Math.sqrt(number);
		
		IntStream.rangeClosed(minRange, maxRange)
			.boxed()
//			.peek(s -> System.out.println(s + "==" + ((int) Math.sqrt(s) * Math.sqrt(s))))
//			.filter(number -> (number == (int) Math.sqrt(number) * Math.sqrt(number)))
			.filter(i->perfectSquares.test(i))
//			.limit(new Random().nextInt(minRange, maxRange))
			.forEach(System.out::println);
	}

}


/*
    int sqrt = (int) Math.sqrt(number);
   
    if(sqrt*sqrt == number) {
        System.out.println(number+" is a perfect square number!");
    }else {
        System.out.println(number+" is NOT a perfect square number!");
    }
*/