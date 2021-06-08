package com.prac.core.problem.immutable;

import java.util.ArrayList;
import java.util.List;

public class PersonImpl {

	public static void main(String[] args) {
		
		List<Degree> degreeList = new ArrayList<>();
		degreeList.add(new Degree("MSc"));
		degreeList.add(new Degree("MBA"));
		degreeList.add(new Degree("BA"));
		
		Person p = new Person("RK", degreeList);
		
		System.out.println(p);
		
		degreeList.add(new Degree("BE"));
		degreeList.add(new Degree("BSc"));
		
		System.out.println(p);
	}

}
