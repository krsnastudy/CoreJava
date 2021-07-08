package com.prac.core.jdk8.predefinedfunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StringPredicate {

	public static void main(String[] args) {
		
		Predicate<String> p = S->S.length()>5;
		System.out.println("Predicate<String>: "+p.test("Krishna"));
		
		String str = "The default methods were introduced to provide backward compatibility so that existing interfaces can use the lambda expressions without implementing the methods in the implementation class. Default methods are also known as defender methods or virtual extension methods ";
		str =  str + "The default methods were introduced to provide backward compatibility so that existing interfaces can use the lambda expressions without implementing the methods in the implementation class. Default methods are also known as defender methods or virtual extension methods";
		
		String[] sArr = str.split(" ");
		
		List<String> s = new ArrayList<>();
		Arrays.stream(sArr).forEach(x->s.add(x));
		int len = 9;
		
		System.out.println("\nPrinting words length>"+len+" :");
//		s.stream()
		Arrays.stream(sArr)
		 .filter(x->!x.isEmpty())
		 .distinct()
		 .filter(l->l.length()>len)
//		 .sorted() // Natural Sorting
		 .sorted((a,b)->b.compareTo(a)) // Descending
//		 .sorted((a,b)->(b.length()-a.length())) // Descending
//		 .forEach(System.out::println);
		 .forEach(x->System.out.println(x+" - "+x.length()));
	}
}