package com.prac.core.jdk5.design.chainofresponsibility;

public class Kiosk {

	private static FiveHundredRupeesHandler fivehundredRupeesHandler = new FiveHundredRupeesHandler();
	private static TwoHundredRupeesHandler twohundredRupeesHandler = new TwoHundredRupeesHandler();
	private static HundredRupeesHandler hundredRupeesHandler = new HundredRupeesHandler();
	private static FiftyRupeesHandler fiftyRupeesHandler = new FiftyRupeesHandler();
	private static TwentyRupeesHandler twentyRupeesHandler = new TwentyRupeesHandler();
	private static FiveRupeesHandler fiveRupeesHandler = new FiveRupeesHandler();
	private static OneRupeesHandler oneRupeesHandler = new OneRupeesHandler();

	static {
		// Construct the chain of Rupees Handlers
		fivehundredRupeesHandler.nextHandler(twohundredRupeesHandler);
		twohundredRupeesHandler.nextHandler(hundredRupeesHandler);
		hundredRupeesHandler.nextHandler(fiftyRupeesHandler);
		fiftyRupeesHandler.nextHandler(twentyRupeesHandler);
		twentyRupeesHandler.nextHandler(fiveRupeesHandler);
		fiveRupeesHandler.nextHandler(oneRupeesHandler);
	}// static

	public void payment(long givenAmount) {
		fivehundredRupeesHandler.fetchRupees(givenAmount);
	}//payment

}// Kiosk
