package com.prac.core.jdks.jdk5.map;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;

public class HashMap1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500); 
		double total = 0;

		for (Integer cost : costBeforeTax) { 
			double price = cost + .12*cost; 
				   total = total + price; 
			} 
		System.out.println("jdk5 Total : " + total); 

		// New way: 
		List<Integer> costBeforeTax1 = Arrays.asList(100, 200, 300, 400, 500); 
		double bill = costBeforeTax1.stream()
						.map((cost) -> cost + .12*cost)
						.reduce((sum, cost) -> sum + cost).get();
		
		System.out.println("(reduce) Total : " + bill);
		
		//Get count, min, max, sum, and average for numbers 
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29); 
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println(stats);
		/*
		 * System.out.println("Highest prime number in List : " + stats.getMax());
		 * System.out.println("Lowest prime number in List : " + stats.getMin());
		 * System.out.println("Sum of all prime numbers : " + stats.getSum());
		 * System.out.println("Average of all prime numbers : " + stats.getAverage());
		 */

		List<Double> dbl = Arrays.asList(2.1, 3.3, 5.5, 7.3, 11.2, 13.2, 17.8, 19.8, 23.2, 29.3); 
		DoubleSummaryStatistics dStats = dbl.stream().mapToDouble(y->y).summaryStatistics();
		System.out.println(dStats);
		
		List<Integer> primeCheck = Arrays.asList(new Integer[]{2,3,5,7});
		int factor = 2;
		primeCheck.forEach(element -> { 
			int tmp=0;
			System.out.print((factor*element)+" "); 
			System.out.print((++tmp)+" "+"\n");
		});
	}
}
