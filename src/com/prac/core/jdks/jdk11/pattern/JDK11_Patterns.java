package com.prac.core.jdks.jdk11.pattern;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class JDK11_Patterns {
    public static void main(String[] args) {
        var str = Pattern.compile("aba").asMatchPredicate();
        System.out.println(str.test("aba"));

        Pattern pattern = Pattern.compile("^\\d{3}-\\d{2}-\\d{4}$"); // US SSN format
        Predicate<String> isSSN = pattern.asMatchPredicate();

        System.out.println(isSSN.test("123-45-6789")); // true
        System.out.println(isSSN.test("123456789"));   // false

    }
}

/**
 * asMatchPredicate(): This method is similar to Java 8 method asPredicate(). Introduced in JDK 11, this method will create a predicate if the pattern matches with the input string.
 ***/