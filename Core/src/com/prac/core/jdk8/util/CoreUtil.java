package com.prac.core.jdk8.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class CoreUtil {

	public static boolean isPrime(int i) {
		IntPredicate isDivisible = index -> i % index == 0;
		return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
	}

	public static int getRandomInt() {
		return new Random().nextInt(99999);
	}

	public static List<Integer> getRandomNumbers(int count) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			list.add(getRandomInt());
		}

		return list;
	}

	public static String getRandomString(int length) {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = length;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		// System.out.println(generatedString);

		// get First letter of the string
		String firstLetStr = generatedString.substring(0, 1);
		// Get remaining letter using substring
		String remLetStr = generatedString.substring(1);

		// convert the first letter of String to uppercase
		firstLetStr = firstLetStr.toUpperCase();

		// concantenate the first letter and remaining string
		generatedString = firstLetStr + remLetStr;

		return generatedString;
	}

	public static List<String> getRandomNames(int strlength, int count) {
		List<String> list = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			list.add(getRandomString(strlength));
		}

		return list;
	}

	public static int getRandomNumberUsingInts(int min, int max) {
		Random random = new Random();
		return random.ints(min, max)
				.findFirst()
				.getAsInt();
	}

	public static int getRandomNumberUsingNextInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

	public static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	public static int getRandomNumber() {
		return (int) ((Math.random() * (15 - 5)) + 5);
	}

}// CoreUtil
