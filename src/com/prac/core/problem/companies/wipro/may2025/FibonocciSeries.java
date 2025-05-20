package com.prac.core.problem.companies.wipro.may2025;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonocciSeries {
    public static void main(String[] args) {
        Object[] array =
                Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                        .limit(10)
                        .map(n -> n[0])
                        .collect(Collectors.toList()).toArray();

        System.out.println(Arrays.toString(array));
    }
}
