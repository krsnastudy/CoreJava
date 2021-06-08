package com.prac.core.problem.immutable;

import java.util.ArrayList;
import java.util.List;

public final class Person {

	private String name;
	private List<Degree> degree;

	public Person(String name, List<Degree> degree) {
		super();
		this.name = name;
		//this.degree = degree;
		
		List<Degree> temp = new ArrayList<>();
		for(int i=0; i<degree.size();i++) {
			temp.add(degree.get(i));
		}
		
		this.degree = temp;		
	}

	public String getName() {
		return name;
	}

	public List<Degree> getDegree() {
		return degree;
//		return Collections.unmodifiableList(degree);
//		return (List<Degree>) ((Object) degree).clone();
/*		
		List<Degree> temp = new ArrayList<>();
		for(int i=0; i<this.degree.size();i++) {
			temp.add(this.degree.get(i));
		}
		
		return temp;
*/		
	}

	@Override
	public String toString() {
		return "Person [Name=" + name + ", Degree=" + degree + "]";
	}
	
}
