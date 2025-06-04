package com.prac.core.problem.companies.EagleTech.jun2025;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseWords {
    public static void main(String[] args) {

        //Reverse string
        String str = "i.like.this.program.very.much";

        System.out.println(str);

        String[] strArray = str.replaceAll("\\.", " ").split(" ");

        List<String> stringList = Arrays.stream(strArray)
                .collect(Collectors.toList());

        String collect = IntStream.rangeClosed(0, stringList.size() - 1)
                .mapToObj(i -> stringList.get(stringList.size() - i - 1))
                .collect(Collectors.joining("."));

        System.out.println(collect);




        ///  Simple
        String revWords = Arrays.stream(str.split("\\.+"))
                .reduce((a, b) -> b + "." + a)
                .orElse(".");

        System.out.println(revWords);
    }
}

// 0 leng-1

/**
 * Input: str = "i.like.this.program.very.much"
 * Output: str = "much.very.program.this.like.i"
 */
