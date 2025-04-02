package com.prac.core.jdks.jdk8.string;

public class SwapTwoStrings {
    public static void main(String[] args) {
        String str1 = "Radha";
        String str2 = "Krishna";
        System.out.println("B4 Swap: " + str1 + " " + str2);

        // Step 1: Concatenate both strings
        str1 = str1 + str2;  // Now str1 = "HelloWorld"

        // Step 2: Extract str2 from the combined string
        str2 = str1.substring(0, str1.length() - str2.length());  // str2 = "Hello"

        // Step 3: Extract str1 from the combined string
        str1 = str1.substring(str2.length());  // str1 = "World"
        
        System.out.println("A4 Swap: " + str1 + " " + str2);

    }
}
