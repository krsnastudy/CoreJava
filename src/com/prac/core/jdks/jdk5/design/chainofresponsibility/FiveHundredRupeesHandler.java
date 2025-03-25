package com.prac.core.jdks.jdk5.design.chainofresponsibility;

public class FiveHundredRupeesHandler extends RupeesHandler {

	@Override
	public void fetchRupees(long givenAmount) {
System.out.println("FiveHundredRupeesHandler");
		long numberofNotesToBeFetched = givenAmount / 500;

		if (numberofNotesToBeFetched > 0) {
			System.out.println(
					numberofNotesToBeFetched + ", Five Hundred Rupees notes are Fetched by FiveHundredRupeesHandler");
		} else {
			System.out.println(
					numberofNotesToBeFetched + ", Five Hundred Rupees note is Fetched by FiveHundredRupeesHandler");
		}

		long pendingRupeesToBeProcessed = givenAmount % 500;
		System.out.println("Pending Amount to be Processed after 500: "+pendingRupeesToBeProcessed);
		if (pendingRupeesToBeProcessed > 0) {
			rupeesHandler.fetchRupees(pendingRupeesToBeProcessed);
		}
		
	}// fetch()
}//FiveHundredRupeesHandler
