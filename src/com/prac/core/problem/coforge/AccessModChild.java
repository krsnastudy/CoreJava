package com.prac.core.problem.coforge;

public class AccessModChild extends AccessModParent{
    public String method1(){ // child class cannot have protected error shown below comments
        System.out.println("Method1");
        return null;
    }
}

/*
* 'method1()' in 'com.prac.core.problem.coforge.AccessModChild' clashes with 'method1()'
* in 'com.prac.core.problem.coforge.AccessModParent';
* attempting to assign weaker access privileges ('protected'); was 'public'
*
* */