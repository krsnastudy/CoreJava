package com.prac.core.jdk5.classloader;

public class ClassB extends ClassA{

//	protected void run() {  //Cannot reduce the visibility of the inherited method from ClassA
	public void run() {
		System.out.println("From B");
	}
}
