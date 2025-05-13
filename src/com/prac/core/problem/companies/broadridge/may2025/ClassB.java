package com.prac.core.problem.companies.broadridge.may2025;

import java.io.IOException;

public class ClassB extends ClassA{
    public void m1() { //throws IOException {
        System.out.println("ClassB");
    }

    public static void main(String[] args) {
        ClassB b = new ClassB();
        b.m1();
    }
}

/*

'm1()' in 'com.prac.core.problem.companies.broadridge.may2025.ClassB' clashes with 'm1()'
in 'com.prac.core.problem.companies.broadridge.may2025.ClassA';
overridden method does not throw 'java.io.IOException'
 */