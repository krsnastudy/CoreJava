package com.prac.core.jdk8.predefinedfunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		
		Predicate<Integer> p = I->(I%2==0); //I->I>10;
		System.out.println("Predicate.test: "+p.test(10));
		System.out.println("Predicate.test: "+p.test(11));
		
		//System.out.println("Predicate.test: "+p.test("6"));
		//The method test(Integer) in the type Predicate<Integer> is not applicable for the arguments (String)
		
		List<Integer> l = new ArrayList<>();
		l.add(17);
		l.add(1);
		l.add(300);
		l.add(50);
		l.add(10);
		l.add(9);
		l.add(12);
		l.add(0);
		l.add(20);
		l.add(-2);
		l.add(-8);
		l.add(-15);
		
		System.out.print("Printing (x>5): ");
		l.stream()
		 .filter(i->(i>0)&&(i%2==0)&&(i<100))
		 .sorted((a,b)->(b-a)) //Descending Order
		 .forEach(x->System.out.print(x+" "));
	}
}

/*
Predicate is a boolean valued function, contains test()
It can always take Some Input values and perform some 
operations provided and returns boolean true or false
*/