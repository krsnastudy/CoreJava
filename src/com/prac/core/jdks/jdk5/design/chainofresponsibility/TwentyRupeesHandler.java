package com.prac.core.jdks.jdk5.design.chainofresponsibility;

public class TwentyRupeesHandler extends RupeesHandler {

	public void fetchRupees(long givenAmount) {
		
		System.out.println();
		System.out.println("TwentyRupeesHandler");
		
		long numberofNotesToBeFetched = givenAmount / 20;
		
		if (numberofNotesToBeFetched > 0) {
			
			if (numberofNotesToBeFetched > 1) {
				System.out.println(
						numberofNotesToBeFetched + ", Twenty Rupees notes are Fetched by TwentyRupeesHandler");
			} else {
				System.out.println(
						numberofNotesToBeFetched + ", Twenty Rupees note is Fetched by TwentyRupeesHandler");
			}//If-Else
			
		}//If

		long pendingRupeesToBeProcessed = givenAmount % 20;
		System.out.println("Pending Amount to be Processed after 20: "+pendingRupeesToBeProcessed);
		if (pendingRupeesToBeProcessed > 0) {
			rupeesHandler.fetchRupees(pendingRupeesToBeProcessed);
		}
	}//fetchRupees
}//TwentyRupeesHandler