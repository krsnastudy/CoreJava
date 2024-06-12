package com.prac.core.jdk5.string.permutation;

//Java program to implement
//the above approach
public class PermutationNumber {

//Function to Swap two 
//characters
	static void swap_(char[] a, int l, int i) {
		char temp;
		temp = a[l];
		a[l] = a[i];
		a[i] = temp;
	}

//Function to generate all permutations 
//and print the ones that are 
//divisible by the N 
	static void permute(char[] str, int l, int r, int n) {
		int i;

		if (l == r) {

			// Convert String to integer
			int j = Integer.valueOf(String.valueOf(str));

			// Check for divisibility
			// and print it
			if (j % n == 0)
				System.out.print(String.valueOf(str) + "\n");

			return;
		}

		// Print all the permutations
		for (i = l; i < r; i++) {

			// Swap characters
			swap_(str, l, i);

			// Permute remaining
			// characters
			permute(str, l + 1, r, n);

			// Revoke the swaps
			swap_(str, l, i);
		}
	}

//Driver Code 
	public static void main(String[] args) {
		String str = "125";
		int n = 5;
		int len = str.length();

		if (len > 0)
			permute(str.toCharArray(), 0, len, n);
	}

}
