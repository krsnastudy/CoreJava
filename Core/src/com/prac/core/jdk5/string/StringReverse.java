package com.prac.core.jdk5.string;

public class StringReverse {

	public static void main(String[] args) {
		String str = "India";
		for(int i=str.length()-1; i>=0;i--) {
			System.out.print(str.charAt(i));
		}
		
		System.out.println();
		
		char[] c = str.toCharArray();
		for(int i=c.length-1; i>=0; i--) {
			System.out.print(c[i]);
		}
		
		System.out.println();
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb.reverse());
	}
}
