package com.prac.core.jdk5.design.abstractFactory;

public class TestDesignPatterns {

	public static void main(String[] args) {
		testAbstractFactory();
	}

	private static void testAbstractFactory() {
		Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB", "500 GB", "2.4 GHz"));
		System.out.println("AbstractFactory PC Config::" + pc);

		Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB", "1 TB", "2.9 GHz"));
		System.out.println("AbstractFactory Server Config::" + server);
	}
}


/*
//https://www.journaldev.com/1418/abstract-factory-design-pattern-in-java

In the Abstract Factory pattern, we get rid of if-else block and have a factory class for each sub-class. 
Then an Abstract Factory class that will return the sub-class based on the input factory class. 
At first, it seems confusing but once you see the implementation, it’s really easy to grasp and 
understand the minor difference between Factory and Abstract Factory pattern.

Abstract Factory Design Pattern Benefits:
Abstract Factory design pattern provides approach to code for interface rather than implementation.
Abstract Factory pattern is “factory of factories” and can be easily extended to accommodate more products, 
for example we can add another sub-class Laptop and a factory LaptopFactory.
Abstract Factory pattern is robust and avoid conditional logic of Factory pattern.

Abstract Factory Design Pattern Examples in JDK
javax.xml.parsers.DocumentBuilderFactory#newInstance()
javax.xml.transform.TransformerFactory#newInstance()
javax.xml.xpath.XPathFactory#newInstance()
*/