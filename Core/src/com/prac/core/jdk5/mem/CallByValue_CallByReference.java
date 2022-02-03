package com.prac.core.jdk5.mem;

public class CallByValue_CallByReference {

	public static void main(String[] args) {

		int a = 10;
		String s = "ABC";
		System.out.println("In main() Init() " + a);
		methodOne(a);
		System.out.println("In main() After() " + a);

		System.out.println("In main() Init() " + s + " -- " + s.hashCode());
		methodTwo(s);
		System.out.println("In main() After() " + s + " -- " + s.hashCode());

	}

	public static void methodOne(int passValue) {
		System.out.println("In methodOne() Init() " + passValue);
		passValue = passValue + 10;
		System.out.println("In methodOne() After() " + passValue);

	}

	public static void methodTwo(String passValue) {
		System.out.println("In methodTwo() Init() " + passValue + " -- " + passValue.hashCode());
		passValue = passValue + "New";
		System.out.println("In methodTwo() After() " + passValue + " -- " + passValue.hashCode());

	}
}


// https://www.youtube.com/watch?v=0Z1eM4Dzrcc&ab_channel=TechGatha
