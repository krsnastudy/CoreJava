package com.prac.core.jdk5.string;

public class StringIntern {

	public static void main(String[] args) {
		String s1 = new String("ABC");
		String s2 = "ABC";
		
		System.out.println("B4 Intern() s1==s2 --> "+(s1==s2));
		System.out.println(s1.hashCode()+" <--> "+s2.hashCode());
		
		s1=s1.intern();
		
		System.out.println("\nA4 Intern() s1==s2 --> "+(s1==s2));
		System.out.println(s1.hashCode()+" <--> "+s2.hashCode());
	}

}
