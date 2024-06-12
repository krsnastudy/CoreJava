package com.prac.core.jdk5.string;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import org.apache.commons.lang3.StringUtils;

public class PallindromeTest {

	public static void main(String[] args) {

		Set<String> set = new HashSet<>();
		set.add("Hare Krishna");
		set.add("Hare Rama");
		set.add("Rama Rama");
		set.add("Hare Hare");
		System.out.println(set);

		int n = 45354;
		String s = "MADAM";
		System.out.println(n + " Is " + (nPallindrome(n) ? "Pallindrome" : "Not Pallindrome"));
		System.out.println(s + " Is " + (sPallindrome(s) ? "Pallindrome" : "Not Pallindrome"));
		System.out.println("Is " + s + " a isPalindrome_Java8 String? " + isPalindrome_Java8(s));
		System.out.println("Is " + s + " a isPalindrome_StringBuilder String? " + isPalindrome_StringBuilder(s));
		System.out.println("Is " + s + " a isPalindrome_Apache_StringUtils String? " + isPalindrome_Apache_StringUtils(s));
	}

	public static boolean nPallindrome(int n) {
		boolean isPallindrome = false;
		int rem, sum = 0, temp = n;

		while (n > 0) {
			rem = n % 10;
			sum = rem + (sum * 10);
			n = n / 10;
		}

		isPallindrome = (temp == sum) ? true : false;
		return isPallindrome;
	}

	public static boolean sPallindrome(String str) {
		String reverse = "";

		for (int i = (str.length() - 1); i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}
		return reverse.equals(str);
	}

	public static boolean isPalindrome_Java8(String originalString) {
		String tempString = originalString.replaceAll("\\s+", "").toLowerCase();
		return IntStream.range(0, tempString.length() / 2)
				.noneMatch(i -> tempString.charAt(i) != tempString.charAt(tempString.length() - i - 1));
	}

	public static boolean isPalindrome_StringBuilder(String originalString) {
		String reversedString = new StringBuilder(originalString).reverse().toString();
		return originalString.equals(reversedString);
	}
	
	public static boolean isPalindrome_Apache_StringUtils(String orinalString) {
        String reversedString = StringUtils.reverse(orinalString);
        return orinalString.equals(reversedString);
    }
}

/*

https://techndeck.com/how-to-check-if-a-string-is-a-palindrome-using-java-8-streams/
*/