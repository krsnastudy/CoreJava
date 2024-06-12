package com.prac.core.jdk8.dateandtime;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TimeIntervals {
    public static void main(String[] args) {
        List<String> intervals = new ArrayList<>();
        IntStream.range(0, 24).forEach(m-> intervals.add((LocalTime.of(m, 00).toString())+"-"+(LocalTime.of(m, 59).toString())));
//        System.out.println(intervals);
        intervals.forEach(System.out::println);
    }
}
