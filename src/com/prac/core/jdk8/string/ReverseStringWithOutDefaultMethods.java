package com.prac.core.jdk8.string;

import com.prac.core.jdk5.arrays.Array;

import java.util.Arrays;

public class ReverseStringWithOutDefaultMethods {
    public static void main(String[] args) {
        String str = "Java 8 functional programming";
        System.out.println("Given : " + str);
        String revStr = Arrays.stream(str.split("\\s+")).reduce((a, b) -> b + " " + a).get();
        System.out.println("Type1 : " + revStr);

        String str1 = "Java 8 functional programming";
        String revStr1 = "";

        for (int i = str1.length() - 1; i >= 0; i--) {
            revStr1 += str1.charAt(i);
        }

        System.out.println("Type2 : " + revStr1);

    }
}
