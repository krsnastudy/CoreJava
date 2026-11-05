package com.prac.core.problem.companies.deloitte.nov042026;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GoldenNumber {
    public static void main(String[] args) {
        int start = 10, end = 100;

        List<Integer> goldenPriceList =
                IntStream.rangeClosed(start, end)
                        .boxed()
                        .filter(f -> golden(f))
                        .collect(Collectors.toList());

        System.out.println("\nGolden Prices List between " + start + " & " + end + " :: " + goldenPriceList.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println("Golden Prices Summation " + goldenPriceList.stream().reduce((a, b) -> a + b).get());
    }

    public static boolean golden(int num) {
        boolean result = false;
        String strNum = String.valueOf(num);
        List<Integer> iList = Arrays.stream(strNum.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

//        int max = iList.stream().max(Comparator.comparing(Integer::intValue)).get();
        int max = iList.stream().max(Integer::compareTo).get();
//        System.out.println("Max :: "+max);

        int sum = iList.stream().reduce(0, Integer::sum);
//        System.out.println("Sum :: "+sum);

        if ((sum - max == max)) {
//            System.out.println("Number : " + num + " - Max is " + max + " & Sum is " + sum);
            result = true;
        }

        return result;
    }
}


/*
That rule explains the total of **495**:

A price is “golden” when:
sum of its digits − largest digit = largest digit

For a two-digit number, this means the smaller digit must equal the larger digit—so the digits must match. From 10 to 100, the golden prices are:
11, 22, 33, 44, 55, 66, 77, 88, 99

Their total is:
11 + 22 + 33 + 44 + 55 + 66 + 77 + 88 + 99 = 495
100 does not qualify: 1 − 1 = 0, which is not equal to the largest digit (1).
**/