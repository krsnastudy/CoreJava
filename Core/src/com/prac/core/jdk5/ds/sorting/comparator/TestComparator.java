package com.prac.core.jdk5.ds.sorting.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

class TestComparator {
	public static void main(String args[]) {
//Creating a list of students  
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student(101, "Vijay", 23));
		al.add(new Student(106, "Ajay", 27));
		al.add(new Student(105, "Jai", 21));

		System.out.println("\nSorting by Name");
//Using NameComparator to sort the elements  
		Collections.sort(al, new NameComparator());
//Traversing the elements of list  
		for (Student st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}

		System.out.println("\nSorting by Age");
//Using AgeComparator to sort the elements  
		Collections.sort(al, new AgeComparator());
//Travering the list again  
		for (Student st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}

		
		System.out.println("\nSorting by RollNo");
		Comparator<Student> ageComparator = 
				Comparator.comparing(Student::getRollno).reversed();
		
		al.stream()
			.sorted(ageComparator)
			.collect(Collectors.toList())
			.forEach(System.out::println);
	}
}