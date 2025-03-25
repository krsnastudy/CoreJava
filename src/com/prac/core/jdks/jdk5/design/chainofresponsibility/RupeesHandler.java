package com.prac.core.jdks.jdk5.design.chainofresponsibility;

public abstract class RupeesHandler {
	RupeesHandler rupeesHandler;

	public void nextHandler(RupeesHandler rupeesHandler) {
		this.rupeesHandler = rupeesHandler;
	}

	public abstract void fetchRupees(long givenAmount);

}
