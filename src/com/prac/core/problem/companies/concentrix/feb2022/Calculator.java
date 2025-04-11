package com.prac.core.problem.companies.concentrix.feb2022;

import java.math.BigDecimal;

public interface Calculator {

	static Number sum(Number... elems) {
		Number total = 0;
		if (elems.length > 0) {
			for (Number x : elems) {
				total = BigDecimal.valueOf(x.doubleValue()).add(BigDecimal.valueOf(total.doubleValue()));
			}
		}
		return total;
	}

	Number tax(Number... original);

	Number tax(String countryCode, Number... original);
}