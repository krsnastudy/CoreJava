package com.prac.core.practice;

import java.util.Random;
import java.util.stream.IntStream;

public class TablesPrint {
    public static void main(String[] args) {
        int lhs = new Random().nextInt(1, 99);
        int rhs = new Random().nextInt(1, 9);

        IntStream.iterate(1, n -> n + 1)
                .limit(165)
                .forEach(e -> System.out.println(new Random().nextInt(101, 999) + " X " + new Random().nextInt(101, 999) + " = "));
    }
}
