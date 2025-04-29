package com.prac.core.problem.companies.ibm.goldmansacs.may2022;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Person p1 = new Person("xyz", 35);
        Person p2 = new Person("xyz", 25);
        Set<Person> set = new HashSet<>();
        set.add(p1); set.add(p2);
        System.out.println(set);
    }
}


class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}