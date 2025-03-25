package com.prac.core.jdks.jdk5.design.strategy;

public class OperationStrategyDivide implements Strategy {

	@Override
	public int doOperation(int num1, int num2) {
		if (num2 == 0)
			return 0;
		else
			return num1 / num2;
	}
}