package com.prac.core.jdk5.string;

public class NumberToWord {

	public void pw(int n, String ch) {
		StringBuffer sb = new StringBuffer();
		String one[] = { "", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten",
				" Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen",
				" Nineteen" };
		String ten[] = { " ", " ", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty",
				" Ninety" };

		if (n > 19) {
			// System.out.print(ten[n/10]+""+one[n%10]);
			sb.append(ten[n / 10]).append("").append(one[n % 10]);
			System.out.print(sb.toString());
		} else {
			// System.out.print(one[n]);
			sb.append(one[n]);
			System.out.print(sb.toString());
		}

		if (n > 0)
			System.out.print(ch);
	}

	public static void main(String[] args) {
		int n = 985875215;
		/*
		 * Scanner scanf = new Scanner(System.in);
		 * System.out.println("Enter an integer number: "); n = scanf.nextInt();
		 */

		if (n <= 0)
			System.out.println("Enter numbers greater than 0");
		else {
			NumberToWord a = new NumberToWord();
			a.pw((n / 1000000000), " Hundred");
			a.pw((n / 10000000) % 100, " Crore");
			a.pw(((n / 100000) % 100), " Lakh");
			a.pw(((n / 1000) % 100), " Thousand");
			a.pw(((n / 100) % 10), " Hundred");
			a.pw((n % 100), " ");
		}
	}
}
