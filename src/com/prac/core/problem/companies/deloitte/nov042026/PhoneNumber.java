package com.prac.core.problem.companies.deloitte.nov042026;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PhoneNumber {
    public static void main(String[] args) {
        String sPno = "1234567890";

        Function<List<Integer>, String> format = f -> f.stream().map(String::valueOf).collect(Collectors.joining());

        Map<Boolean, List<Integer>> collect =
                IntStream.rangeClosed(1, sPno.length())
                        .boxed()
                        .collect(Collectors.partitioningBy(
                                i -> i % 2 == 0,
                                Collectors.mapping(i -> Character.getNumericValue(sPno.charAt(i - 1)),
                                        Collectors.toList())
                        ));
        System.out.println("Map partitioningBy :: " + collect);
        String result = format.apply(collect.get(false)) + format.apply(collect.get(true));
        System.out.println("Given  :: "+sPno);
        System.out.println("Result :: "+result);

    }
}

/**
 * To print the digits at odd indexes first, followed by the even indexes
 **/