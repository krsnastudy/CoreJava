package com.prac.core.problem.companies.luxoft.jan2022;

public class OverLoadTest {
    public static void main(String[] args) {

        add(1F,2);
    }

    public static void add(int a, float b){
        System.out.println("add(int a, float b)");
    }

    public static void add(float a, int b){
        System.out.println("add(float a, int b)");
    }
}

/*
* add(1,2); ERROR
* Ambiguous method call.
* Both add(int,float) in OverLoadTest
* and add(float,int) in OverLoadTest match
*
*
* add(1F,2);
*/
