package com.prac.core.problem.concentrix;

public class CalculatorTest {
	public static void main(String[] args) {

		Calculator cal = (Calculator) new DefaultCalculator();
		Calculator calFruit = (Calculator) new FruitCalculator();
		DefaultCalculator defal = (DefaultCalculator) calFruit;

		System.out.println("DefaultCalculator: " + cal.tax(1, 3, 4, 10));
		System.out.println("FruitCalculator: " + calFruit.tax(1, 3, 4, 10));
		System.out.println("DefaultCalculator(FruitCalculator): " + defal.tax(+1, 3, 4, 10));
	}
}
