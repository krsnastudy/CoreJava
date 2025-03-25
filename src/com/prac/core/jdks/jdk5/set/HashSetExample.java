package com.prac.core.jdks.jdk5.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		Person p1 = new Person("xyz", 25);
		Person p2 = new Person("xyz", 35);
		
		Set<Person> hSet = new HashSet<>();
		
		hSet.add(p1);
		hSet.add(p2);
		
		hSet.forEach(p->System.out.println(p.toString()));
	}

}
