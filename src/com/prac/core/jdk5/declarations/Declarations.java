package com.prac.core.jdk5.declarations;

import java.util.LinkedHashMap;
import java.util.Map;

public class Declarations {

	public static void main(String[] args) {

		String str = "abcba";
		char[] c = str.toCharArray();
		Map<Character, Integer> lm = new LinkedHashMap<>();
		char key = 0;
		for (int i = 0; i < c.length; i++) {
			if (lm.containsKey(c[i])) {
				key = c[i];
				break;
			} else {
				lm.put(c[i], 1);
				// lm.put(c[i], lm.getOrDefault(c[i], 0) + 1);
			}
		}

		System.out.println("Key: " + key);
		System.out.println(lm);
	}

}

// 2147483647