package com.prac.core.problem.companies.HCL.apr2025;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCount {
    public static void main(String[] args) {
        String str = "radhakrishna";

        Map<String, Long> collect = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);
    }
}
