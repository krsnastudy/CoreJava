package com.prac.core.jdks.jdk8.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PrintWordByLength {
    public static void main(String[] args) {
        String str = "Simply put, a facade encapsulates a complex subsystem behind a simple interface. It hides much of the complexity and makes the subsystem easy to use. Also, if we need to use the complex subsystem directly, we still can do that; we aren't forced to use the facade all the time. Besides a much simpler interface, there's one more benefit of using this design pattern. It decouples a client implementation from the complex subsystem. Thanks to this, we can make changes to the existing subsystem and don't affect a client. Let's see the facade in action.";
        String lengthyString = Arrays.stream(str.split("\\s+"))
                .sorted(Comparator.comparing(String::length).reversed())
                .collect(Collectors.joining(" "));

        System.out.println("B4 :: "+str);
        System.out.println("A4 :: "+lengthyString);
    }
}
