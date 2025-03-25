package com.prac.core.jdks.jdk5.design.chainofresponsibility;

public class HundredRupeesHandler extends RupeesHandler {

	public void fetchRupees(long givenAmount) {
		System.out.println();
		System.out.println("HundredRupeesHandler");
		long numberofNotesToBeFetched = givenAmount / 100;
		
		if (numberofNotesToBeFetched > 0) {
			
			if (numberofNotesToBeFetched > 1) {
				System.out.println(
						numberofNotesToBeFetched + ", Hundred Rupees notes are Fetched by HundredRupeesHandler");
			} else {
				System.out.println(
						numberofNotesToBeFetched + ", Hundred Rupees note is Fetched by HundredRupeesHandler");
			}
		}

		long pendingRupeesToBeProcessed = givenAmount % 100;
		System.out.println("Pending Amount to be Processed after 100: "+pendingRupeesToBeProcessed);
		if (pendingRupeesToBeProcessed > 0) {
			rupeesHandler.fetchRupees(pendingRupeesToBeProcessed);
		}

	}// fetchRupees
}// HundredRupeesHandler
