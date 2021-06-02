package com.prac.core.jdk5.ds.sorting.comparable;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableExample {
	public static void main(String args[]) {
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student(101, "Vijay", 33));
		al.add(new Student(106, "Ajay", 97));
		al.add(new Student(105, "Jai", 25));

		Collections.sort(al);
		for (Student st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}
	}
}