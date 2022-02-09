package com.prac.core.jdk8.string;

public class StringTest {
	int iVal = 85;

	public static void main(String[] args) {

		String s1 = "Hello ";
		s1 += "World";
		String s2 = "Hello ";
		s2 += "";
		s2 += "World";
		String s3 = s1.intern();
		String s4 = s2.intern();

		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));

		StringTest s = new StringTest();
		System.out.println(s.iVal);

		Animals[] animals = Animals.values();
		System.out.println(animals[1]);
	}

	StringTest() {
		iVal = 41;
	}

	{
		iVal = 27;
	}

	enum Animals {
		LION, DOG, COW;
	}
}
