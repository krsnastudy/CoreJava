package com.prac.core.problem.gen;

public class IntegerTest {

	public static void main(String[] args) {

//		Integer num1 = new Integer(100);
		Integer num1 = 100;
		Integer num2 = 100;
		
		Integer num3 = 500;
		Integer num4 = 500;
		
		Integer num5 = new Integer(127);
		Integer num6 = new Integer(127);

		if (num1 == num2) {
			System.out.println("num1 == num2");
		} else {
			System.out.println("num1 != num2");
		}

		if (num3 == num4) {
			System.out.println("num3 == num4");
		} else {
			System.out.println("num3 != num4");
		}
		
		if (num3.equals(num4)) {
			System.out.println("num3.equals(num4)");
		} else {
			System.out.println("!num3.equals(num4)");
		}
		
		System.out.println("num5 == num6: "+(num5 == num6));
		System.out.println("(num5.equals(num6)): "+((num5.equals(num6))));
	}
}


/*

Java Integer Cache: Why Integer.valueOf(127) == Integer.valueOf(127) Is True

https://dzone.com/articles/java-integer-cache-why-integervalueof127-integerva

The short answer to this question is, direct assignment of an int literal to an Integer 
reference is an example of auto-boxing concept where the literal value to object conversion code is handled by the compiler, 
so during compilation phase compiler converts Integer a = 127; to Integer a = Integer.valueOf(127);.

The Integer class maintains an internal IntegerCache for integers which, by default, 
ranges from -128 to 127 and Integer.valueOf() method returns objects of mentioned range from that cache. 
So a == b returns true because a and b both are pointing to the same object.

*/