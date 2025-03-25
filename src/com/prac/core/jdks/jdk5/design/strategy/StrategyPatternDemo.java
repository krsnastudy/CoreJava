package com.prac.core.jdks.jdk5.design.strategy;

public class StrategyPatternDemo {

	public static void main(String[] args) {
		
		Context a = new Context(new OperationStrategyAdd());
		System.out.println("StrategyPattern Addition: "+a.executeStrategy(3, 2));
		
		Context s = new Context(new OperationStrategySubtract());
		System.out.println("StrategyPattern Substraction: "+s.executeStrategy(3, 2));
		
		Context d = new Context(new OperationStrategyDivide());
		System.out.println("StrategyPattern Divide: "+d.executeStrategy(10, 2));
		
		Context m = new Context(new OperationStrategyMultiply());
		System.out.println("StrategyPattern Multiply: "+m.executeStrategy(10, 2));
	}
}

/*
-- Used in SocGen Project
In Strategy pattern, a class behavior or its algorithm can be changed at run time. 
This type of design pattern comes under behavior pattern.

In Strategy pattern, we create objects which represent various strategies and 
a context object whose behavior varies as per its strategy object. 
The strategy object changes the executing algorithm of the context object.

https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
*/