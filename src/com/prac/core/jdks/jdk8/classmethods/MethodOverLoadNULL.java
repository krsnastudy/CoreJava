package com.prac.core.jdks.jdk8.classmethods;

import com.prac.core.jdks.jdk8.stream.employee.data.Employee;

public class MethodOverLoadNULL {
    // Driver code
    public static void main(String[] args) {
        MethodOverLoadNULL mv = new MethodOverLoadNULL();
        mv.fun((Integer) null);
        mv.MethodObject(5);
    }

    // Overloaded methods
    public void fun(Integer i) {
        System.out.println("fun(Integer) got called");
    }

    public void fun(String name) {
        System.out.println("fun(String) got called ");
    }

    public void MethodObject(Object object){
        System.out.println("MethodObject: "+object.toString());
    }
}

/*
* mv.fun(null);
* Ambiguous method call. Both
     fun (Integer) in MethodOverLoadNULL and
     fun(String)in MethodOverLoadNULL match
*
* mv.fun((Object) null); //Cannot resolve method 'fun(Object)'
* */