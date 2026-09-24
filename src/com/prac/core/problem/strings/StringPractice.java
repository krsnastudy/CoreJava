package com.prac.core.problem.strings;

public class StringPractice {

	public static void main(String[] args) {

		String str = "Init";
		System.out.println("Init Hashcode: "+str.hashCode()+" String: "+str);

		str = "Destroy";
		System.out.println("Destroy Hashcode: "+str.hashCode()+" String: "+str);

		//str = str.concat(".");
		str.concat(".");
		System.out.println("Concat Hashcode: "+str.hashCode()+" String: "+str);
		
		str = str + ";";
		System.out.println("+ Hashcode: "+str.hashCode()+" String: "+str);
		
		System.out.println(str);
	}

}
