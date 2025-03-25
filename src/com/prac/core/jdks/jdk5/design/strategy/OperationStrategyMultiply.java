package com.prac.core.jdks.jdk5.design.strategy;

public class OperationStrategyMultiply implements Strategy {

	@Override
	public int doOperation(int n1, int n2) {
		return n1 * n2;
	}
}