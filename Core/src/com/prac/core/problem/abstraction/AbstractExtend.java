package com.prac.core.problem.abstraction;

public class AbstractExtend extends AbstractExThree{

	public AbstractExtend(int a) {
		super(a);
	}

	public static void main(String[] args) {
		AbstractExtend o = new AbstractExtend(5);
		o.methodFour();
	}

	@Override
	public void methodFour() {
		System.out.println("AbstractExtend methodFour");
	}

}
