package com.prac.core.jdks.jdk8.fi.fixtndsfi;

public class Example {
    public static void main(String[] args) {
//        B obj = (methodB) -> System.out.println("MethodB executed");
        B obj = new B() {
            @Override
            public void methodB() {
                System.out.println("MethodB executed");
            }

            @Override
            public void methodA() {
                System.out.println("MethodA executed");
            }
        };
        obj.methodB(); // This works as expected.
    }
}
/*
*Error
* Multiple non-overriding abstract methods found in interface com.prac.core.jdks.jdk8.fi.fixtndsfi.B
* */