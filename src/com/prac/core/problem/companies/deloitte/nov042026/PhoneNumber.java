package com.prac.core.problem.companies.deloitte.nov042026;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PhoneNumber {
    public static void main(String[] args) {
        String sPno = "1234567890";

        Function<List<Integer>, String> format = f -> f.stream().map(String::valueOf).collect(Collectors.joining(""));

        Map<Boolean, List<Integer>> collect = IntStream.rangeClosed(1, sPno.length())
                .mapToObj(Integer::valueOf)
                .collect(Collectors.partitioningBy(p -> p % 2 == 0));

        System.out.println("Map partitioningBy :: " + collect);

        String oddNums = collect.get(false).stream().map(String::valueOf).collect(Collectors.joining(""));
        String evenNums = collect.get(true).stream().map(String::valueOf).collect(Collectors.joining(""));
        String result = oddNums + evenNums;
//        System.out.println(result);

        String result1 = format.apply(collect.get(false)) + format.apply(collect.get(true));
        System.out.println(result1);

//        collect.get(false).forEach(f -> System.out.print(sPno.charAt(f - 1)));
//        collect.get(true).forEach(f -> System.out.print(sPno.charAt(f - 1)));

    }
}

/**To print the digits at odd indexes first, followed by the even indexes**/