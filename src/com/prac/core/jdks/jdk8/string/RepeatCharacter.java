package com.prac.core.jdks.jdk8.string;

import java.util.stream.Collectors;

public class RepeatCharacter {
    public static void main(String[] args) {
        String str = "complexity";
        System.out.println(str.repeat(2));

        String collect = str.chars()
                .mapToObj(m -> (char) m)
                .map(String::valueOf)
                .map(m -> m.repeat(2))
                .collect(Collectors.joining());
        System.out.println(collect);
    }
}
