package com.prac.core.jdk5.design.strategy;

public class OperationStrategyAdd implements Strategy {

	@Override
	public int doOperation(int num1, int num2) {
		return num1 + num2;
	}
}