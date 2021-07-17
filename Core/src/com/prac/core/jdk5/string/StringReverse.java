package com.prac.core.jdk5.string;

public class StringReverse {

	public static void main(String[] args) {
		
		String str = "INDIA";
		System.out.println("Given String: "+str);
		
		System.out.print("String Reverse by String.charAt(index)  : ");
		for(int i=str.length()-1; i>=0;i--) {
			System.out.print(str.charAt(i));
		}
		
		System.out.print("\nString Reverse by String.toCharArray()  : ");
		char[] c = str.toCharArray();
		for(int i=c.length-1; i>=0; i--) {
			System.out.print(c[i]);
		}
		System.out.println();
		System.out.print("String Reverse by StringBuffer.reverse(): ");
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb.reverse());
	}
}
