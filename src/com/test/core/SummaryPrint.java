package com.test.core;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SummaryPrint {
    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1,new Random().nextInt(10, 50))
                                      .boxed()
                                      .collect(Collectors.toList());

        int max = list.stream().max(Comparator.comparing(Integer::intValue)).get();
        int min = list.stream().min(Comparator.reverseOrder()).get();
        IntSummaryStatistics intSummaryStatistics =
                list.stream().collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println(intSummaryStatistics);
    }
}
