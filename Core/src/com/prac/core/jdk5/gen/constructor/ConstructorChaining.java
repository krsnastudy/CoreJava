package com.prac.core.jdk5.gen.constructor;

public class ConstructorChaining {

	public static void main(String[] args) {
		System.out.println("Creating ClassA Object");
		ClassA objA = new ClassA();
		
		System.out.println("\nCreating ClassB Object");
		ClassB objB = new ClassB();
		
		System.out.println("\nCreating ClassA ClassB Object");
		ClassA objAB = new ClassB();		
		
	}

}

/*
//https://www.geeksforgeeks.org/constructor-chaining-java-examples/
Constructor chaining is the process of calling one constructor from another constructor with respect to current object.
Constructor chaining can be done in two ways:

Within same class: It can be done using this() keyword for constructors in same class
From base class: by using super() keyword to call constructor from the base class.
Constructor chaining occurs through inheritance. A sub class constructor’s task is to call super class’s constructor first. 
This ensures that creation of sub class’s object starts with the initialization of the data members of the super class. 
There could be any numbers of classes in inheritance chain. 
Every constructor calls up the chain till class at the top is reached.

Why do we need constructor chaining ?
This process is used when we want to perform multiple tasks in a single constructor rather than creating a code 
for each task in a single constructor we create a separate constructor for each task and make their 
chain which makes the program more readable.
*/