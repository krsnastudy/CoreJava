package com.prac.core.jdks.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SumOfOddNumberSquare {

    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<>();
        int k = 49;

/*		for (int i = 1; i < 1500; i++) {
			aList.add(i);
		}*/

        IntStream.rangeClosed(1, 1500).forEach(m -> aList.add(m));
        int res = aList.stream()
                .filter(i -> i % 2 == 1)
                .map(x -> x * x)
                .reduce(0, Integer::sum);

        System.out.println("Square: " + res);
//        check(aList, k);

        Function<Integer, Integer> square = x -> x*x;
        Function<Integer, Integer> cube = x -> x*x*x;

        Integer reduce = IntStream.rangeClosed(1, 1500).boxed().filter(i -> i % 2 != 0).map(x -> x * x).reduce(0, Integer::sum);
        Integer reduceSquare = IntStream.rangeClosed(1, 1500).boxed().filter(i -> i % 2 != 0).map(square).reduce(0, Integer::sum);
        Integer reduceCube = IntStream.rangeClosed(1, 1500).boxed().filter(i -> i % 2 != 0).map(cube).reduce(0, Integer::sum);

        System.out.println(reduce);
        System.out.println(reduceSquare);
        System.out.println(reduceCube);
    }

    public static void check(List<Integer> aList, int diff) {
        for (int i = 0; i < aList.size(); i++) {
            for (int j = i + 1; j < aList.size(); j++) {
                if ((((aList.get(j) - aList.get(i)) == diff)) || (((aList.get(i) - aList.get(j)) == diff))) {
                    System.out.print("(" + i + "," + j + "), ");
                }
            }
        }
    }
}