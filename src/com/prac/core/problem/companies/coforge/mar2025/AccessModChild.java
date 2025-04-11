package com.prac.core.problem.companies.coforge.mar2025;

public class AccessModChild extends AccessModParent{
    public String method1(){ // child class cannot have protected error shown below comments
        System.out.println("Method1");
        return null;
    }
}

/*
* 'method1()' in 'com.prac.core.problem.companies.coforge.mar2025.AccessModChild' clashes with 'method1()'
* in 'com.prac.core.problem.companies.coforge.mar2025.AccessModParent';
* attempting to assign weaker access privileges ('protected'); was 'public'
*
* */