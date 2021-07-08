package com.prac.core.jdk8.predefinedfunctions.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StringPredicate {

	public static void main(String[] args) {

		Predicate<String> p = S -> S.length() > 5;
		System.out.println("Predicate<String>: " + p.test("Krishna"));
//		System.out.println("Predicate<String> negate: "+p.negate());

		String str = "The default methods were introduced to provide backward compatibility so that existing interfaces can use the lambda expressions without implementing the methods in the implementation class. Default methods are also known as defender methods or virtual extension methods ";
		str = str
				+ "The default methods were introduced to provide backward compatibility so that existing interfaces can use the lambda expressions without implementing the methods in the implementation class. Default methods are also known as defender methods or virtual extension methods 	";

		String[] sArr = str.split(" ");

		List<String> s = new ArrayList<>();
		Arrays.stream(sArr).forEach(x -> s.add(x));
		int len = 9;

		System.out.println("\nPrinting words length>" + len + " :");
//		s.stream()
		Arrays.stream(sArr)
				.distinct()
				.filter(x -> !x.isEmpty())
				.filter(y -> y.charAt(0) == 'i')
				.filter(l -> l.length() > len)
//				.filter(n->n!=null)
				//.sorted() // Natural Sorting
				.sorted((a, b) -> b.compareTo(a)) // Descending
				//.sorted((a,b)->(b.length()-a.length())) // Descending
				//.forEach(System.out::println);
				.forEach(x -> System.out.println(x + " - " + x.length()));

		System.out.println("\nPredicate By Normal Function: ");
		Predicate<String> p1 = s1 -> s1.length() > 5;
		Predicate<String> p2 = a -> (a.length() % 2 == 0);
//		m1(p1.negate().and(p2), s);
	}

	public static void m1(Predicate<String> p, List<String> s) {
		s.forEach(x -> System.out.println(x + " --> " + p.test(x)));
	}
}