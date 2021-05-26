package com.prac.core.problem.gen;

public class FindProduct {

	public static void main(String[] args) {

		int[] b = new int[5];
		b[0]=1;
		
		int[] a = {1, 2, 3, 4, 5};
		int answer=1;
		int pow = (int) (Math.pow(10, 9)+7);
			
		for (int i = 0; i < a.length; i++) {
			answer = (answer*a[i])%pow;
		}
		
		System.out.println("answer: "+answer);
	}

}
//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/find-product/
