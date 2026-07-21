package com.prac.core.practice;

import java.util.Arrays;

public class StringPractice {
    public static void main(String[] args) {
        String str = "RadhaKrishna";
        System.out.println("Reverse :: "+Arrays.stream(str.split("")).reduce("",(a,b)->b+a));;

        Arrays.stream(str.split(""))
                .forEach(System.out::println);
    }
}