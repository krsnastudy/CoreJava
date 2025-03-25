package com.prac.core.jdks.jdk8.gen.tribonacci;

public class TribonacciSeries {

	public static void main(String[] args) {
		int n = 15;
		// function calling
		int ans = tribonacciTerm(n);
		System.out.println("The " + n + "th term of the Tribonacci series is: " + ans);
		printTribonacci(n);
		printTrib(n);
	}

	public static void printTribonacci(int n) {

		int a = 1, b = 0, c = 1;
		int d = a + b + c;
//		System.out.print(a + ", " + b + ", " + c + ", ");

		for (int i = 4; i <= n; i++) {
			System.out.print(d + ", ");
			a = b;
			b = c;
			c = d;
			d = a + b + c;
		}
		System.out.println();
	}

	public static int tribonacciTerm(int n) {
		StringBuffer sb = new StringBuffer();
		if (n < 3)
			return n;
		// initializing the first three terms of the Tribonnaci series
		int a = 0, b = 1, c = 1, d;
		// in the while loop --> is not an operator. These are two separate operators,
		// -- and >.
		// the conditional's code decrements n by 1, while returning n's original value
		// not decremented value
		// after that compares the original value with 3 using the > operator.
		// more specifically we can write it as while ((n--) > 3)
		while (n-- > 3) {
			d = a + b + c;
			a = b;
			b = c;
			c = d;
		}

		return c;
	}

	public static void printTrib(int n) {
		for (int i = 1; i < n; i++)
			System.out.print(printTribRec(i) + " ");
	}

	public static int printTribRec(int n) {

		if (n == 0 || n == 1 || n == 2)
			return 0;

		if (n == 3)
			return 1;
		else
			return printTribRec(n - 1) + printTribRec(n - 2) + printTribRec(n - 3);
	}
}

/*
 * 
 * https://www.javatpoint.com/tribonacci-series-in-java
 * 
 * Tribonacci Series A Tribonacci sequence or series is a sequence of integers
 * such that each term from the fourth onward is the sum of the previous three
 * terms. The Tribonacci sequence can be defined as follows:
 * 
 * T0=0, T1=T2=1 Tn=Tn-1+Tn-2+Tn-3 (n≥3) In other words, we can say that each
 * term of the series is the sum of the previous three terms. The first few
 * terms of Tribonacci series are:
 * 
 * 0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504, 927, 1705, 3136, 5768,
 * 10609, 19513, 35890, 66012, 121415, 223317, 410744, 755476, 1389537, 2555757,
 * 4700770, 8646064, 15902591, 29249425, 53798080, 98950096, 181997601,
 * 334745777, 615693474, 1132436852… so on.
 * 
 */