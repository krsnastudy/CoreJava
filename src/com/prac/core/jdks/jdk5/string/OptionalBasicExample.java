package com.prac.core.jdks.jdk5.string;

import java.util.Arrays;
import java.util.Optional;

public class OptionalBasicExample {

	public static void main(String[] args) {

		int[] iArray = new int[5];
		iArray[4] = 5;

		String[] str = new String[10];
		str[5] = "JAVA OPTIONAL CLASS EXAMPLE";

		System.out.println("   int Array: " + Arrays.toString(iArray));
		System.out.println("String Array: " + Arrays.toString(str));

		Optional<String> checknull = Optional.ofNullable(str[0]);

		System.out.println("\nOptional.isEmpty() " + checknull.isEmpty());
		System.out.println("Optional.isPresent() " + checknull.isPresent());

		System.out.println();

		if (checknull.isPresent()) { // It Checks, value is present or not
			String lowercaseString = str[5].toLowerCase();
//            System.out.print(lowercaseString); 
			System.out.println("Optional.isPresent() " + checknull.get());
		} else
			System.out.println("String value is not present");
	}
}
