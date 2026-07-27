package com.prac.core.practice;

import com.prac.core.jdks.jdk5.arrays.Array;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestPractice {
    public static void main(String[] args) {
        String str = "explore the internal working of ArrayList";

        String revStr = Arrays.stream(str.split(" "))
                .reduce("", (a,b)->b+" "+a);

        String reduce = Stream.of(str.split("")).reduce("", (a, b) -> b + a);

        String revCollect = Arrays.stream(str.split(" "))
                .collect(Collectors.toList())
                .stream().map(TestPractice::reverseStr)
                .collect(Collectors.joining(" "));

        System.out.println(str);
        System.out.println(revCollect);
        System.out.println(revStr);
        System.out.println(reduce);
    }

    public static String reverseStr(String str){
        return Stream.of(str.split("")).reduce("", (a,b)->b+a);
    }
}

//Stream.of(str.split("")).reduce("", (r,c)->c+r);
//Stream.of(str.split(" ")).reduce("", (a, b) -> b + " " + a);