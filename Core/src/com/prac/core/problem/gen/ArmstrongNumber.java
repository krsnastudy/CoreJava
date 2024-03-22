package com.prac.core.problem.gen;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArmstrongNumber {

	public static void main(String[] args) {
		int res = 0;
		int check = 1634; // 1634, 371
//		res = checkArmstrong_JDK5(check);
		res = checkArmstrong_JDK8(check);
		System.out.println();
		System.out.println(res == check ? check + " is an Armstrong Number" : check + " is Not an Armstrong Number");


		/* 
		 * int x = 200;
		 * System.out.println("\nArmstrong Numbers upto " + x + " : \n" +
		 * getArmstrongNumberSequence(x).stream().map(m -> m +
		 * "").collect(Collectors.joining(", ")));
		 */
	}

	public static int checkArmstrong_JDK5(int number) {
		String str = number + "";
		int res = 0;
		char[] cArr = str.toCharArray();

		for (int i = 0; i < cArr.length; i++) {
			int num = Character.getNumericValue(cArr[i]);
//			int temp = num*num*num;
			int temp = (int) Math.pow(num, 3);
			res = res + temp;
		}

		return res;
	}

	public static int checkArmstrong_JDK8(int num) {

		int pow = String.valueOf(num).length();
		System.out.println("Length of Numeric Value " + num + " is " + pow + "\n");

//		System.out.println(IntStream.iterate(1, n->n+1).limit(pow).sum());

		return IntStream.iterate(num, i -> i / 10)
				.peek(p -> System.out.println("Value --> " + p + " && (" + p + " % 10) --> " + (p % 10))).limit(pow)
				.map(i -> (int) Math.pow(i % 10, pow)) // Mod is Remaining value
				.sum();
	}

	public static boolean isArmstrongNumber(int num) {
		if (num < 0) {
			return false;
		}

		return (num == checkArmstrong_JDK8(num));
	}

	public static List<Integer> getArmstrongNumberSequence(int limit) {
		if (limit < 0) {
			throw new IllegalArgumentException("The limit cannot be a negative number.");
		}
		return IntStream.range(0, limit).boxed().filter(ArmstrongNumber::isArmstrongNumber)
				.collect(Collectors.toList());
	}

}

// https://www.baeldung.com/java-armstrong-numbers