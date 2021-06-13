package com.prac.core.jdk5.gen.constructor;

public class ClassB extends ClassA{
	
	ClassB(){
		this(1);
		System.out.println("In ClassB()");
	}
	
	ClassB(int a){
		this(1, 2);
		System.out.println("In ClassB(int a)");
	}
	
	ClassB(int a, int b){
		this(1f);
		System.out.println("In ClassB(int a, int b)");
	}
	
	ClassB(float a){
		this("String");
		System.out.println("In ClassB(float a)");
	}
	
	ClassB(String a){
		this(new Integer(1));
		System.out.println("In ClassB(String a)");
	}
	
	ClassB(Integer a){
		System.out.println("In ClassB(Integer a)");
	}
}
