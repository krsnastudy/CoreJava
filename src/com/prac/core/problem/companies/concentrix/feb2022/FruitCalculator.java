package com.prac.core.problem.companies.concentrix.feb2022;

import java.math.BigDecimal;

public class FruitCalculator extends DefaultCalculator {
	private float taxRate = 0.2f;

	@Override
	public Number tax(Number... original) {
		// get default tax rate
		return BigDecimal.valueOf(Calculator.sum(original).doubleValue())
				.multiply(new BigDecimal(Float.toString(taxRate)));
	}

	@Override
	public Number tax(String countryCode, Number... original) {
		return super.tax(countryCode, original);
	}
}