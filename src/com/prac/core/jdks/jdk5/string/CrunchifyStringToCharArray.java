package com.prac.core.jdks.jdk5.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CrunchifyStringToCharArray {
	static String firstPart;

	public static void main(String[] args) {
		String testString = "xyararia";
		testString = testString.replace(" ", "").toLowerCase();

		String sortString = sortString(testString);

		System.out.println("Original: " + testString);
		System.out.println("Sorted: " + sortString);
		String remaining = uniqueString(sortString);

		String FirstPartFinal = firstPart;
		String remainingFinal = uniqueString(remaining);

		StringBuffer sb = new StringBuffer(firstPart);
		String finalString = FirstPartFinal + sb.reverse().toString() + remainingFinal;

		finalString = finalString.replace(" ", "");
		System.out.println("Final : " + finalString);

	}

	public static String uniqueString(String testString) {

		String[] sArr = testString.split("");

		List<String> list = Stream.of(sArr)
				// .sorted()
				// .map(c->c.split(""))
				.distinct().collect(Collectors.toList());

		// System.out.println("Unique: "+list);

		for (String string : list) {
			testString = testString.replaceFirst(string, "");
			// System.out.println(string+" Replace: "+testString);
		}

//		firstPart= list.toString();
		StringBuffer sb = new StringBuffer();
		for (String s : list) {
			sb.append(s);
			sb.append(" ");
		}
		firstPart = sb.toString();

		return testString;
	}

	public static String sortString(String inputString) {
		// convert input string to char array
		char tempArray[] = inputString.toCharArray();

		// sort tempArray
		Arrays.sort(tempArray);

		// return new sorted string
		return new String(tempArray);
	}

}
