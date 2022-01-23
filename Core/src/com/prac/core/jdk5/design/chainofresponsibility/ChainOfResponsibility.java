package com.prac.core.jdk5.design.chainofresponsibility;

public class ChainOfResponsibility {

	public static void main(String[] args) {
		
		long processAmount = 1896;
		
		Kiosk kiosk = new Kiosk();
		System.out.println("Processing Amount is "+processAmount+"\n");
		kiosk.payment(processAmount);
		
	}//psvm
	
}//ChainOfResponsibility


/*
 
https://examples.javacodegeeks.com/core-java/java-chain-of-responsibility-design-pattern-example/

This pattern is useful for modelling requests and handling events if we do not know the number and type of handlers in advance. 
The event – based systems, purchasing systems and shipping systems, ATM, 
Bill Payment Kiosk are real life examples that places well with the chain of responsibility pattern. 
Thus it concludes that Chain of Responsibility pattern allows multiple objects in a chain to handle a request object. 
The request flows through the chain until it is handled by a link in the chain. 
The chain of responsibilities design pattern is a very powerful pattern. 
A chain of chains can also be implemented, creating a multi- dimensional structure.

*/