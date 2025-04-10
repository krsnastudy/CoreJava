package com.prac.core.jdks.jdk5.equalsandhashcode;

import java.util.HashSet;
import java.util.Set;

public class EqualsHashCodeTesting {
    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();
        people.add(new Person("John"));
        System.out.println("HashSet Data : "+people);
        System.out.println(people.contains(new Person("John"))); // false ❌

    }
}
