package com.prac.core.jdks.jdk8.handson;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumNumbers {
	public static void main(String[] args) {
		List<Integer> iList = Arrays.asList(2, 9, 10, 8, 4, 7);
		
		//Using Stream.collect()
		Integer sum1 = iList.stream().collect(Collectors.summingInt(Integer::intValue));
		System.out.println("Stream.collect() Sum: "+sum1);
		
		//Using Stream.reduce()
		Integer sum2 = iList.stream().reduce(0, (a, b)->a+b);
		System.out.println("Stream.reduce()  Sum: "+sum2);
		
		//Using IntStream.sum()
		Integer sum3 = iList.stream().mapToInt(Integer::intValue).sum();
		System.out.println("IntStream.sum()  Sum: "+sum3);
		
		//Sum of all numbers in an array
		int[]integers = {2, 9, 10, 8, 4, 7};
		Integer sum4 = Arrays.stream(integers).sum();
		System.out.println("    array.sum()  Sum: "+sum4);
		
		//Sum of all numbers in a Set
		Set<Integer> intSet = Stream.of(2, 9, 10, 8, 4, 7).collect(Collectors.toSet());
		
		Integer sum5 = intSet.stream()
		        .mapToInt(Integer::intValue)
		        .sum();
		System.out.println("      Set.sum()  Sum: "+sum5);
	}
}
