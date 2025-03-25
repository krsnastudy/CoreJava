package com.prac.core.jdks.jdk5.design.chainofresponsibility;

public class OneRupeesHandler extends RupeesHandler {

	@Override
	public void fetchRupees(long givenAmount) {

		System.out.println();
		System.out.println("OneRupeesHandler");

		long numberofNotesToBeFetched = givenAmount / 1;

		if (numberofNotesToBeFetched > 0) {
			System.out.println(numberofNotesToBeFetched + ", One Rupee Coins are Fetched by OneRupeesHandler");
		} // If

		long pendingRupeesToBeProcessed = givenAmount % 1;
		System.out.println("Pending Amount to be Processed after 1: " + pendingRupeesToBeProcessed);
		if (pendingRupeesToBeProcessed > 0) {
			rupeesHandler.fetchRupees(pendingRupeesToBeProcessed);
		}
	}
}
