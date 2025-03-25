package com.prac.core.jdks.jdk5.design.chainofresponsibility;

public class FiftyRupeesHandler extends RupeesHandler {

	public void fetchRupees(long givenAmount) {
		System.out.println();
		System.out.println("FiftyRupeesHandler");
		long numberofNotesToBeFetched = givenAmount / 50;

		if (numberofNotesToBeFetched > 0) {
			
			if (numberofNotesToBeFetched > 1) {
				System.out.println(numberofNotesToBeFetched + ", Fifty Rupees notes are Fetched by FiftyRupeesHandler");
			} else {
				System.out.println(numberofNotesToBeFetched + ", Fifty Rupees note is Fetched by FiftyRupeesHandler");
			}
		}

		long pendingRupeesToBeProcessed = givenAmount % 50;
		System.out.println("Pending Amount to be Processed after 50: "+pendingRupeesToBeProcessed);
		if (pendingRupeesToBeProcessed > 0) {
			rupeesHandler.fetchRupees(pendingRupeesToBeProcessed);
		}

	}// fetchRupees
}// FiftyRupeesHandler