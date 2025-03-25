package com.prac.core.jdks.jdk8.classmethods;

public class MethodOverLoadNULL {
    // Overloaded methods
    public void fun(Integer i) {
        System.out.println("fun(Integer ) ");
    }

    public void fun(String name) {
        System.out.println("fun(String ) ");
    }

    // Driver code
    public static void main(String[] args) {
        MethodOverLoadNULL mv = new MethodOverLoadNULL();

        // This line causes error
//        mv.fun(null); // Ambiguous method call. Both
        mv.fun((Integer) null);
    }
}
