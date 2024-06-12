package com.prac.core.problem.strings;

public class StringPractice {

	public static void main(String[] args) {

		String str = "Init";
		System.out.println("Init Hashcode: "+str.hashCode());
		
		str = "Destroy";
		System.out.println("Destroy Hashcode: "+str.hashCode());
		
		str.concat(".");
		System.out.println("Concat Hashcode: "+str.hashCode());
		
		str = str + ";";
		System.out.println("+ Hashcode: "+str.hashCode());
		
		System.out.println(str);
	}

}
