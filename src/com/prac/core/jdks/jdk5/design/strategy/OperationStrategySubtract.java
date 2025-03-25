package com.prac.core.jdks.jdk5.design.strategy;

public class OperationStrategySubtract implements Strategy {

	@Override
	public int doOperation(int num1, int num2) {

		if (num1 > num2)
			return num1 - num2;
		else if (num2 > num1)
			return num2 - num1;
		else
			return 0;
	}
}