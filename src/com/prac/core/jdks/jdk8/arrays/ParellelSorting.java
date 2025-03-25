package com.prac.core.jdks.jdk8.arrays;

import java.util.Arrays;
import java.util.function.Consumer;

public class ParellelSorting {

	public static void main(String[] args) {
		Consumer<Integer> print = i -> System.out.print(i + " ");

		int numbers[] = { 22, 89, 1, 32, 19, 5 };
		System.out.print("       Given Array: ");
		Arrays.stream(numbers).forEach(i -> print.accept(i));

		System.out.print("\nparallelSort Array: ");
		// Parallel Sort method for sorting int array
		Arrays.parallelSort(numbers);
		// converting the array to stream and displaying using forEach
//		Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
		Arrays.stream(numbers).forEach(i -> print.accept(i));

		System.out.print("\n\n     Given another Array: ");
		int anotherNumbers[] = { 21, 20, 11, 2, 6, 18, 5 };
		Arrays.stream(anotherNumbers).forEach(i -> print.accept(i));
		/*
		 * Specifying the start and end index. The start index is 1 here and the end
		 * index is 5. which means the the elements starting from index 1 till index 5
		 * would be sorted.
		 * 
		 * It Excludes the ToIndex position. eg: In given Array positions 1 2 3 4 will
		 * be sorted and position 5 will not be included for sorting
		 */

		System.out.print("\nParallelSort Array Range: ");
		Arrays.parallelSort(anotherNumbers, 1, 5);
		// converting the array to stream and displaying using forEach
//		Arrays.stream(anotherNumbers).forEach(n -> System.out.print(n + " "));
		Arrays.stream(anotherNumbers).forEach(i -> print.accept(i));
	}
}

/*
 * https://beginnersbook.com/2017/10/java-8-arrays-parallel-sort-with-example/
 * 
 * Java 8 introduced a new method parallelSort() in the Arrays class of
 * java.util package. This method is introduced to support the parallel sorting
 * of array elements. Algorithm of parallel sorting: 1. The given array is
 * divided into the sub arrays and the sub arrays are further divided into the
 * their sub arrays, this happens until the sub array reaches a minimum
 * granularity. 2. The sub arrays are sorted individually by multiple threads.
 * The parallel sort uses Fork/Join Framework for sorting sub arrays parallelly.
 * 3. The sorted sub arrays are merged.
 * 
 * Advantage of Parallel Sort Over Simple Sort: The parallelSort() method uses
 * the concept of multithreading which makes it much faster compared to the
 * normal sort when there are lot of elements.
 * 
 */
