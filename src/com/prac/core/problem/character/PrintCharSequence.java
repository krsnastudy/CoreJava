package com.prac.core.problem.character;

import java.util.stream.IntStream;

public class PrintCharSequence {
    public static void main(String[] args) {
        String regex = "[^a-zA-Z0-9]";

        IntStream.rangeClosed(0, 1000).boxed()
                .map(i-> (char) i.intValue())
//                .peek(System.out::println)
                .filter(i-> String.valueOf(i).matches(regex))
//                .map(i-> i+" --> "+(Character.valueOf((char) i)))
                .forEach(System.out::println);
    }
}
