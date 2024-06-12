package com.prac.core.jdk5.ds.fibonacci;

public class FibonacciTest {
    public static void main(String[] args) {
        int n = 9;
        Fibonacci.getFibonacci(n);
        System.out.println("Fibonacci Series Element("+n+") is "+Fibonacci.getNthFibOne(n));
        System.out.println("Fibonacci Element("+n+") is "+Fibonacci.getNthFibJdk8(n));
        Fibonacci.printFibonacciSum(n);
        Fibonacci.printFibonacciSeries(n);
    }
}
