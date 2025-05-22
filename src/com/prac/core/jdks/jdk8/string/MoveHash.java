package com.prac.core.jdks.jdk8.string;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MoveHash {
    public static void main(String[] args) {
        MoveHash moveHash = new MoveHash();
        String input = "Move#Hash#to#Front";
        String result;
        result = moveHash.moveHashCode(input);
        System.out.println(result);

        String collect1 = input.chars()
                .mapToObj(c -> (char) c)
                .filter(f1 -> f1.equals('#'))
                .map(String::valueOf).collect(Collectors.joining(""));

        String collect2 = input.chars()
                .mapToObj(c -> (char) c)
                .filter(f2 -> !f2.equals('#'))
                .map(String::valueOf)
                .collect(Collectors.joining(""));

        System.out.println(collect1.concat(collect2));

        System.out.println(moveHashCode_JDK8(input));
    }

    public String moveHashCode(String input) {
        String str1 = new String("");
        String str2 = new String("");
        int length = input.length();
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == '#') {
                str1 += input.charAt(i);
            } else {
                str2 += input.charAt(i);
            }
        }

        return str1.concat(str2);
    }

    public static String moveHashCode_JDK8(String input) {
        String collect = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.partitioningBy(i -> !Character.valueOf(i).equals('#')))
                .entrySet().stream()
                .map(m -> m.getValue())
                .map(m->String.valueOf(m.toArray()))
                .collect(Collectors.joining());
        return collect;
    }

}
