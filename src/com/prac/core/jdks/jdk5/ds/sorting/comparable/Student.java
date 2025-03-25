package com.prac.core.jdks.jdk5.ds.sorting.comparable;

class Student implements Comparable<Student> {
	int rollno;
	String name;
	int age;

	Student(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Student st) {
		/*
		 * if (age == st.age) return 0; else if (age > st.age) return 1; else return -1;
		 */
//		return age-st.age;
		return name.compareTo(st.name);
	}

	@Override
	public String toString() {
		return "Student [Roll# " + rollno + ", Name: " + name + ", Age: " + age + "]";
	}
}