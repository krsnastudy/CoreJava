package com.prac.core.problem;

import java.util.ArrayList;

//Fibonacci Series using Recursion 
class Fibonacci { 
	static int fib(int n) 
	{ 
		if (n <= 1) {
//			fArr.add(n);
			return n;
		}
		return fib(n - 1) + fib(n - 2); 
	} 

	public static void main(String args[]) 
	{ 
		int n = 9; 
		System.out.println(fib(n)); 
		int add=0; int limit=4000000;
		
		ArrayList<Integer> fArr= new ArrayList<>();
		ArrayList<Integer> feArr= new ArrayList<>();
		for(int i=1;add<limit;i++) {
			int f = fib(i);
			fArr.add(f);
			if(f%2==0) {
				feArr.add(f);
				add = add + f;
			}
		}
		 System.out.println("Raw Data: "+fArr);
		 System.out.println("Even Data: "+feArr);
		 System.out.println("even Add: "+add);
	} 
} 
