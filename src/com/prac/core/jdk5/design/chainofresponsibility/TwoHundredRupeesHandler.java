package com.prac.core.jdk5.design.chainofresponsibility;

public class TwoHundredRupeesHandler extends RupeesHandler{

	@Override
	public void fetchRupees(long givenAmount) {
		System.out.println();
		System.out.println("TwoHundredRupeesHandler");
		long numberofNotesToBeFetched = givenAmount / 200;
		
		if (numberofNotesToBeFetched > 0) {
			
			if (numberofNotesToBeFetched > 1) {
				System.out.println(
						numberofNotesToBeFetched + ", Two Hundred Rupees notes are Fetched by TwoHundredRupeesHandler");
			} else {
				System.out.println(
						numberofNotesToBeFetched + ", Two Hundred Rupees note is Fetched by TwoHundredRupeesHandler");
			}
		}

		long pendingRupeesToBeProcessed = givenAmount % 200;
		System.out.println("Pending Amount to be Processed after 200: "+pendingRupeesToBeProcessed);
		if (pendingRupeesToBeProcessed > 0) {
			rupeesHandler.fetchRupees(pendingRupeesToBeProcessed);
		}

	}// fetchRupees
}// TwoHundredRupeesHandler
