package com.prac.core.jdks.jdk5.exception;

public class TryFinallyCatch_Order {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try block");
            int result = 10 / 0; // Exception here
        } finally {
            System.out.println("Inside finally block");
        }/*catch (Exception e) {
            System.out.println("Inside finally block");
//            throw new RuntimeException(e);
        }*/
    }
}

/*
*
* 'catch' without 'try'
*
* "No, try + finally + catch order will NOT work. Compiler will throw an error.
✅ Valid Orders:
try + catch,          try + finally,        try + catch + finally

🔴 Invalid:
try + finally + catch ➔ ❌ Not allowed"
* */