package com.prac.core.jdk5.design.builder;

public class TestBuilderPattern {

	public static void main(String[] args) {
		
		// Using builder to get the object in a single line of code and
		// without any inconsistent state or arguments management issues
		
		Computer comp = new Computer.ComputerBuilder("500 GB", "2 GB")
									.setBluetoothEnabled(true)
//									.setGraphicsCardEnabled(true)
									.build();
		
		System.out.println(comp);
		
	}

}

/*
// https://www.journaldev.com/1425/builder-design-pattern-in-java

There are three major issues with Factory and Abstract Factory design patterns 
when the Object contains a lot of attributes.

Too Many arguments to pass from client program to the Factory class that can be error prone because most of the time, 
the type of arguments are same and from client side its hard to maintain the order of the argument.

Some of the parameters might be optional but in Factory pattern, we are forced to send all the parameters 
and optional parameters need to send as NULL.

If the object is heavy and its creation is complex, then all that complexity will be part of 
Factory classes that is confusing.

We can solve the issues with large number of parameters by providing a constructor with required parameters 
and then different setter methods to set the optional parameters. 

The problem with this approach is that the Object state will be inconsistent until 
unless all the attributes are set explicitly.

Builder pattern solves the issue with large number of optional parameters and inconsistent state by providing a 
way to build the object step-by-step and provide a method that will actually return the final Object.
*/