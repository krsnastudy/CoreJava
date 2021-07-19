package com.prac.core.jdk5.classloader;

public class String {

	public static void main(java.lang.String[] args) {
		System.out.println("Test");
		System.out.println("Loaded By: "+String.class.getClassLoader());
	}
}