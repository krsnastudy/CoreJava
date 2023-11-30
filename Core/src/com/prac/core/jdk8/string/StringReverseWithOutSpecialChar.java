package com.prac.core.jdk8.string;

import java.util.Arrays;

public class StringReverseWithOutSpecialChar {

	public static void main(String[] args) {
		String str = "Ab,c,de!$";
		char[] charArray = str.toCharArray();
		reverse(charArray);
	}

	public static void rev(char s[], int l, int r) {
		for (int i = l; i < r / 2; i++) {
			char temp = s[i];
			s[i] = s[r - 1 - i];
			s[r - 1 - i] = temp;
		}
	}

	public static void reverse(char s[]) {
		// creating character array of size
		// equal to length of string
		char[] temp = new char[s.length];
		int x = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] >= 'a' && s[i] <= 'z' || s[i] >= 'A' && s[i] <= 'Z') {
				// storing elements in array
				temp[x] = s[i];
				x++;
			}
		}
System.out.println("W/O Special Chars: "+Arrays.toString(temp));
		// reversing the character array
		rev(temp, 0, x);
System.out.println("Reverse Chars: "+Arrays.toString(temp));
		x = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] >= 'a' && s[i] <= 'z' || s[i] >= 'A' && s[i] <= 'Z') {
				// updating the origional string
				s[i] = temp[x];
				x++;
			}
		}

		String revStr = new String(s);
		System.out.println("reversed string is: " + revStr);
	}
}
