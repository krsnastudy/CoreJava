package com.prac.core.problem.companies.wipro.may2025;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PrintUniqueChars {
    public static void main(String[] args) {
        String str = "Venkata radhaKrishna Cheetirala";
        str = str.replaceAll(" ", "").toLowerCase();
        Object[] array = str.chars()
                .distinct()
                .mapToObj(m -> (char) m)
                .collect(Collectors.toList())
                .toArray();
        System.out.println(Arrays.toString(array));
    }
}
