package com.prac.core.jdk5.design.chainofresponsibility;

public class FiveRupeesHandler extends RupeesHandler {

	public void fetchRupees(long givenAmount) {
		
		System.out.println();
		System.out.println("FiveRupeesHandler");
		
		long numberofNotesToBeFetched = givenAmount / 5;
		
		if (numberofNotesToBeFetched > 0) {
		
			if (numberofNotesToBeFetched > 1) {
				System.out
						.println(numberofNotesToBeFetched + ", Five Rupees notes are Fetched by FiveRupeesHandler");
			} else {
				System.out.println(numberofNotesToBeFetched + ", Five Rupees note is Fetched by FiveRupeesHandler");

			}//If-Else
			
		}//If

		long pendingRupeesToBeProcessed = givenAmount % 5;
		System.out.println("Pending Amount to be Processed after 5: "+pendingRupeesToBeProcessed);
		if (pendingRupeesToBeProcessed > 0) {
			rupeesHandler.fetchRupees(pendingRupeesToBeProcessed);
		}

	}

}