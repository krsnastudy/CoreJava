package com.prac.core.jdks.jdk5.ds.sorting.comparable;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableExample {
	public static void main(String args[]) {
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student(101, "Vijay", 33));
		al.add(new Student(106, "Ajay", 97));
		al.add(new Student(105, "Jai", 25));

		System.out.println("Before Sorting:");
		al.forEach(System.out::println);

		Collections.sort(al);

		System.out.println("\nAfter Sorting:");
		al.forEach(System.out::println);

		/*
		 * for (Student st : al) { System.out.println(st.rollno + " " + st.name + " " +
		 * st.age); }
		 */
	}
}