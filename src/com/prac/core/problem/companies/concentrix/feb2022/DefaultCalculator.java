package com.prac.core.problem.companies.concentrix.feb2022;

import java.math.BigDecimal;

public class DefaultCalculator implements Calculator {
	protected float taxRate = 0.1f;

	@Override
	public Number tax(Number... original) {
		// get default tax rate
		return BigDecimal.valueOf(Calculator.sum(original).doubleValue()).multiply(new BigDecimal(taxRate));
	}

	@Override
	public Number tax(String countryCode, Number... original) {
		double taxRate = 0.1;
		switch (countryCode) {
		case "US":
			taxRate = 0.11;
			break;
		case "CA":
			taxRate = 0.13;
			break;
		case "MX":
			taxRate = 0.08;
			break;
		default:
			break;
		}
		return BigDecimal.valueOf(Calculator.sum(original).doubleValue()).multiply(new BigDecimal(taxRate));
	}
}