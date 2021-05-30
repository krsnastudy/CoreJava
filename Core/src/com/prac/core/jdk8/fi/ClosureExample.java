package com.prac.core.jdk8.fi;

public class ClosureExample {

	public static void main(String[] args) {
		int i=10; int closureInt=5;
		
		doProcess(i, p->System.out.println(i+closureInt));
	}

	public static void doProcess(int a, Process p) {
		p.process(a);
	}
}

interface Process{
	void process(int a);
}