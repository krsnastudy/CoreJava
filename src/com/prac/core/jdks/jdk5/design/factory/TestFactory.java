package com.prac.core.jdks.jdk5.design.factory;

public class TestFactory {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.4 GHz");
		System.out.println("Factory PC Config::" + pc);

		Computer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");
		System.out.println("Factory Server Config::" + server);

		// ResourceBundle r = null; Uses factory-design-pattern
	}
}

/*
 * // https://www.journaldev.com/1392/factory-design-pattern-in-java
 * 
 * The factory design pattern is used when we have a superclass with multiple
 * sub-classes and based on input, we need to return one of the sub-class. This
 * pattern takes out the responsibility of the instantiation of a class from the
 * client program to the factory class.
 * 
 * Factory Design Pattern Advantages: Factory design pattern provides approach
 * to code for interface rather than implementation. Factory pattern removes the
 * instantiation of actual implementation classes from client code. Factory
 * pattern makes our code more robust, less coupled and easy to extend. For
 * example, we can easily change PC class implementation because client program
 * is unaware of this. Factory pattern provides abstraction between
 * implementation and client classes through inheritance.
 * 
 * Factory Design Pattern Examples in JDK java.util.Calendar, ResourceBundle and
 * NumberFormat getInstance() methods uses Factory pattern. valueOf() method in
 * wrapper classes like Boolean, Integer etc.
 * 
 */