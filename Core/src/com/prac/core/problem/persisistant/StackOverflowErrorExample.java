package com.prac.core.problem.persisistant;

public class StackOverflowErrorExample {
	public void print(int myInt) {
		System.out.println(myInt);
//		print(myInt); // Enable it for StackOverflowError
	}

	public static void main(String[] args) {
		StackOverflowErrorExample soee = new StackOverflowErrorExample();
		soee.print(0);
	}
}

/*
https://rollbar.com/blog/how-to-fix-java-lang-stackoverflowerror-in-java/#:~:text=StackOverflowError%20is%20a%20runtime%20error,by%20deep%20or%20infinite%20recursion.

What Causes java.lang.StackOverflowError in Java
The java.lang.StackOverflowError occurs when the application stack continues to grow until it reaches the maximum limit. 
Some of the most common causes for a java.lang.StackOverflowError are:

Deep or infinite recursion - If a method calls itself recursively without a terminating condition.
Cyclic relationships between classes - If a class A instantiates an object of class B, 
which in turn instantiates an object of class A. This can be considered as a form of recursion.
Memory intensive applications - Applications that rely on resource heavy objects such as XML documents, GUI or java2D classes.

Increase Thread Stack Size (-Xss)
If the code has been updated to implement correct recursion and the program still throws a java.lang.StackOverflowError, 
the thread stack size can be increased to allow a larger number of invocations. 
Increasing the stack size can be useful, for example, when the program involves calling a 
large number of methods or using lots of local variables.

The stack size can be increased by changing the -Xss argument on the JVM, 
which can be set when starting the application. 
Here is an example:
-Xss4m


*/