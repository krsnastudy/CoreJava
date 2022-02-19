package com.prac.core.jdk5.design.singleton;

public class SingleTonTest {

	public static void main(String[] args) {
		SingtonEx s1 = SingtonEx.getInstance();
		SingtonEx s2 = s1;
		SingtonEx s3 = SingtonEx.getInstance();

		System.out.println("SingleTon s1: " + s1.hashCode());
		System.out.println("SingleTon s2: " + s2.hashCode());
		System.out.println("SingleTon s3: " + s3.hashCode());
	}
}