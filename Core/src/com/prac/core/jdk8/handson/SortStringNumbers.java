package com.prac.core.jdk8.handson;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SortStringNumbers {

	public static void main(String[] args) {
		String[] sArr = {"10", "3", "9", "1", "5"};
		
		System.out.println("Given Array: "+Arrays.toString(sArr));
		
		System.out.print("Sorted Array: ");
		Arrays.stream(sArr)
			.map(s->Integer.parseInt(s))
			.sorted()
			.forEach(p->System.out.print(p+" "));
		
		System.out.print("\nPerfect Squares: ");
		IntStream.rangeClosed(1, 100)
			.filter(s -> s == (int) Math.sqrt(s)*Math.sqrt(s))
			.forEach(p->System.out.print(p+"["+(int)Math.sqrt(p)+"]"+" "));
		;
		
		System.out.println();
	}

}


// number -> number == (int) Math.sqrt(number) * Math.sqrt(number)