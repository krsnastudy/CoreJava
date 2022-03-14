package com.prac.core.jdk8.handson;

import java.util.stream.IntStream;

public class FizzBuzzExample {

	public static void main(String[] args) {
		int check = 30;
		int fizz = 2;
		int buzz = 7;
//		checkFizzBuzz_jdk5(check, fizz, buzz);
		checkFizzBuzz_jdk8(check, fizz, buzz);
	}

	public static void checkFizzBuzz_jdk5(int num, int fizz, int buzz) {

		for (int i = 1; i <= num; i++) {
			if ((i % fizz == 0) && (i % buzz == 0)) {
				System.out.print(i + "[Fizz-Buzz], ");
			} else if ((i % fizz == 0)) {
				System.out.print(i + "[Fizz], ");
			} else if ((i % buzz == 0)) {
				System.out.print(i + "[Buzz], ");
			} else {
				System.out.print(i + ", ");
			}
		} // for Loop

	}

	public static void checkFizzBuzz_jdk8(int num, int fizz, int buzz) {
	IntStream.rangeClosed(1, num)
	  .mapToObj(i -> i % fizz == 0 ? (i % buzz == 0 ? i+"[Fizz-Buzz], " : i+"[Fizz], ") : (i % buzz == 0 ? i+"[Buzz], " : i + ", "))
	  .forEach(System.out::print);
	}
}
