package com.prac.core.jdks.jdk8.handson;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SortStringNumbers {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String[] sArr = {"10", "3", "9", "1", "5"};
		int limit = new Random().nextInt(1, 9999);
		Predicate<Integer> perfectSquare = p -> (int) p == Math.sqrt(p) * Math.sqrt(p);
		Predicate<Integer> perfectCube = p -> (int) p == (int)Math.cbrt(p) * (int)Math.cbrt(p) * (int)Math.cbrt(p);

		System.out.println("Given Array: "+Arrays.toString(sArr));
		System.out.print("Sorted Array: ");
		Arrays.stream(sArr)
			.map(s->Integer.parseInt(s))
			.sorted()
			.forEach(p->System.out.print(p+" "));
		
		System.out.print("\n\nPerfect Square Numbers below "+limit+": \n");
		IntStream.rangeClosed(1, limit)
			.filter(s -> s == (int) Math.sqrt(s)*Math.sqrt(s))
//			.filter(s-> perfectSquare.test(s))
			.forEach(p->System.out.print(p+"["+(int)Math.sqrt(p)+"]"+" "));
		
		System.out.print("\n\nPerfect Cube Numbers below "+limit+": \n");
		IntStream.rangeClosed(1, limit)
			.filter(f->perfectCube.test(f))
			.forEach(p->System.out.print(p+"["+(int)Math.cbrt(p)+"]"+" "));
		
		System.out.println();
	}

}


// number -> number == (int) Math.sqrt(number) * Math.sqrt(number)