package com.prac.core.jdk5.string;

import java.util.Arrays;
import java.util.Collections;

public class StringArraySort {

	public static void main(String[] args) {

		String[] sArr = { "Elephant", "Dumble", "Cat", "Apple", "Bat" };

		Arrays.sort(sArr);
		System.out.println("Normal Sort: " + Arrays.toString(sArr));

		Arrays.sort(sArr, (s1, s2) -> s2.length() - s1.length());
		System.out.println("Reverse Sort: " + Arrays.toString(sArr));

		Character[] cArr = { 'A', 'E', 'B', 'D', 'C' };
		Arrays.sort(cArr);
		System.out.println("Normal Sort: " + Arrays.toString(cArr));

		Arrays.sort(cArr, Collections.reverseOrder());
		System.out.println("Reverse Sort: " + Arrays.toString(cArr));
	}

}
