package com.prac.core.jdk8.arrlist;

import java.util.*;
import java.util.stream.Stream;

public class ListFromIterate {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int rank = 5;

        Stream.iterate(1, n->n+1)
                .limit(20)
                .toList()
                .forEach(e->list.add(new Random().nextInt(15000, 99999)));

        System.out.println("Natural "+list);
        System.out.println("Sorted  "+list.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).toList());

        int value = list.stream()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
//                .peek(p-> System.out.print(p+", "))
                .skip(rank-1).findFirst().get();

        System.out.println("\nRank "+rank+" Value: "+value);

        int sum = list.stream().reduce((a,b)->a+b).get();
        System.out.println("Total Sum: "+sum);
    }
}
