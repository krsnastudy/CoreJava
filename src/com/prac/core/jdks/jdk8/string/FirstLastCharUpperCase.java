package com.prac.core.jdks.jdk8.string;

import java.util.stream.IntStream;

public class FirstLastCharUpperCase {
    public static void main(String[] args) {
        String str = "java";

        String resString = IntStream.range(0, str.length())
                .mapToObj(i -> (i == 0 || i == str.length() - 1) ?
                        Character.toUpperCase(str.charAt(i)) : str.charAt(i))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        System.out.println(resString);
    }
}
