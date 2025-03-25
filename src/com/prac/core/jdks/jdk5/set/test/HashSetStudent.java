package com.prac.core.jdks.jdk5.set.test;

import java.util.HashSet;
import java.util.Set;

public class HashSetStudent {
    public static void main(String[] args) {
        Student s1 = new Student("Krishna", "Radha", 1);
        Student s2 = new Student("Krishna", "Radha", 1);

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(s1);
        studentSet.add(s2);
        System.out.println("HashSet Size :: "+studentSet.size());
        studentSet.stream().forEach(System.out::println);
    }
}
