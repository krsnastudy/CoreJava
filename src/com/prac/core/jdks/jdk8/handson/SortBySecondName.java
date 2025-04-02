package com.prac.core.jdks.jdk8.handson;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortBySecondName {

    public static void main(String[] args) {
        String[] sArray = {"Venkata, Saatvik", "Ratan, Tata", "Radha, Krishna", "Kalam, Abdul", "Mishra, Gokul", "Mohit, Bansal", "Kapil, Baarat"};
        System.out.println(Arrays.toString(sArray));

        String collect = Arrays.asList(sArray).stream()
                .sorted((x, y) -> {
                    String[] fs = x.split(",");
                    String[] ss = y.split(",");
                    return fs[1].trim().compareTo(ss[1].trim());
                })
                .map(m -> "[" + m + "]")
                .collect(Collectors.joining(", "));

        System.out.println(collect);
    }

}
