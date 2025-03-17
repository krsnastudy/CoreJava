package com.prac.core.problem.gen;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberPattern {
    public static void main(String[] args) {
        int patternLen = 5;
//        pattern_JDK5();
        pattern_JDK8(patternLen);
    }

    public static void pattern_JDK8(int patternLen) {
        IntStream.rangeClosed(1, patternLen) // Loop from 1 to 5
                .mapToObj(i -> String.valueOf((patternLen+1) - i).repeat(i)) // Generate repeated number strings
                .forEach(System.out::println); // Print each line

//        Stream.iterate(patternLen, n -> n - 1).map(m->String.valueOf((patternLen+1)+m).repeat(m)).forEach(System.out::println);

    }

    public static void pattern_JDK5(int patternLen) {
        for (int i = patternLen; i >= 1; i--) {  // Loop from 5 to 1
            for (int j = 1; j <= ((patternLen+1) - i); j++) {  // Print i, (6-i) times
                System.out.print(i);
            }
            System.out.println();
        }
    }
}

