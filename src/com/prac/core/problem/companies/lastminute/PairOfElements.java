package com.prac.core.problem.companies.lastminute;

import java.util.HashMap;
import java.util.Map;

public class PairOfElements {

	public static void main(String[] args) {
		int arr1[] = { -5, 1, -40, 20, 6, 8, 7 };
		int sum1 = 15;
		findSum(arr1, sum1);
		
		int arr2[] = {-5, 4, -2, 16, 8, 9};
		int sum2 = 15;
		findSum(arr2, sum2);		
		
	}

	static void findSum(int A[], int x) {
		int size = A.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < (size - 1); i++) {
			for (int j = (i + 1); j < size; j++) {
				if (A[i] + A[j] == x) {
//					System.out.println("Pair with a given sum " + x + " is (" + A[i] + ", " + A[j] + ")");
					map.put(A[i], A[j]);
				}
			}
		}

		if (map.isEmpty()) {
			System.out.println("false (There is no pair of elements whose sum is equal to "+x+")");
		} else {
			System.out.println("true "+map+" are the pairs with sum "+x);
		}
	}
}

/*
true {-5=20, 8=7} are the pairs with sum 15
false (There is no pair of elements whose sum is equal to 15)
 */


/*		
Input: A[] = {-5, 1, -40, 20, 6, 8, 7} Target: 15
Output: true ( 7, 8 and -5, 20 are the pairs with sum 15)

Input: A[] = {-5, 4, -2, 16, 8, 9} Target: 15
Output: false (There is no pair of elements whose sum is equal to 15)
*/