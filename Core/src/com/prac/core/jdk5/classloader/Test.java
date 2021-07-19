package com.prac.core.jdk5.classloader;

public class Test {

	public static void main(String[] args) {
//		System.out.println("Loaded By: "+String.class.getClassLoader());
		System.out.println("Loaded By: "+Test.class.getClassLoader());
	}

}
