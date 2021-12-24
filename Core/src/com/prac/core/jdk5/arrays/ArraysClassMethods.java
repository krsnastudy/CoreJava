package com.prac.core.jdk5.arrays;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class ArraysClassMethods {

	public static void main(String[] args) {
		/*
		 * // TODO Auto-generated method stub int a[] = {10, 3, 2, 5, 8, 4, 3, 1,
		 * 1,1,1,1,2, 9, 7, 8}; int a1[] = {10, 3, 2, 5, 8, 4, 3, 1, 1,1,1,1,2, 9, 7,
		 * 8}; int a2[] = {10, 3, 2, 5, 8, 4, 3, 1, 1,2,1,2, 9, 7, 8};
		 * 
		 * Arrays.sort(a); System.out.println(Arrays.binarySearch(a, 9));
		 * System.out.println(Arrays.equals(a1, a2));
		 */
		String s[] = { "-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000" };
		System.out.println("Raw Data");
		Stream.of(s).forEach(i -> System.out.print(i + " "));

		Arrays.sort(s, // a the array to be sorted
				0, // fromIndex the index of the first element (inclusive) to besorted
				s.length, // toIndex the index of the last element (exclusive) to be sorted
				Comparator.comparing(BigDecimal::new, Comparator.reverseOrder())
		/*
		 * c the comparator to determine the order of the array. A null value indicates
		 * that the elements' natural ordering should be used.
		 */
		);

		/*
		 * Arrays.sort(s, 0, s.length, Comparator.comparing(Integer::new,
		 * Comparator.reverseOrder()));
		 */

		/*
		 * for(int i=0;i<s.length;i++) { System.out.println(s[i]); }
		 */
		System.out.println("\nGeneral Sorting");
		Stream.of(s).forEach(i -> System.out.print(i + " "));

		Arrays.sort(s, Collections.reverseOrder(new Comparator<String>() {
			@Override
			public int compare(String a1, String a2) {
				// convert to big decimal inside comparator
				// so permanent string values are never changed
				// aka you only use the BigDecimal values to
				// compare the strings!
				BigDecimal a = new BigDecimal(a1);
				BigDecimal b = new BigDecimal(a2);
				return a.compareTo(b);
			}
		}));
		System.out.println("\nReversal Sorting");
		Stream.of(s).forEach(i -> System.out.print(i + " "));

	}

}
