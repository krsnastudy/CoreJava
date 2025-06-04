package com.prac.core.problem.companies.EagleTech.jun2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinMaxArray {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 7, 8},
                {9, 11, 13},
                {15, 16, 17}
        };
        List<List<Integer>> row = new ArrayList<>();
        List<List<Integer>> column = new ArrayList<>();

        Arrays.stream(matrix).forEach(e -> System.out.println(Arrays.toString(e)));

        for (int i = 0; i < matrix.length; i++) {
            int[] temp = matrix[i];
            row.add(Arrays.stream(temp).boxed().collect(Collectors.toList()));
        }

        List<Integer> minCollect = row.stream()
                .map(m -> m.stream().min(Comparator.comparingInt(Integer::intValue)).get())
                .collect(Collectors.toList());
        System.out.println("Min in Each Row :: " + minCollect);

        for (int i = 0; i < matrix.length; i++) {
            int[] temp = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                temp[j] = matrix[i][j];
            }
            column.add(Arrays.stream(temp).boxed().collect(Collectors.toList()));
        }
        List<Integer> maxCollect = column.stream()
                .map(m -> m.stream().max(Comparator.comparingInt(Integer::intValue)).get())
                .collect(Collectors.toList());
        System.out.println("Max in Each Col :: " + maxCollect);

//        System.out.println(column.stream().map(MinMaxArray::getMax).map(String::valueOf).collect(Collectors.joining(", ")));

        // Java 8 MatrixMinMaxStream
        MatrixMinMaxStream();
    }

    public static void MatrixMinMaxStream() {
        int[][] matrix = {
                {3, 7, 8},
                {9, 11, 13},
                {15, 16, 17}
        };

        System.out.println();
        // Minimum in each row
        System.out.println("Minimum in each row:");
        IntStream.range(0, matrix.length)
                .forEach(i -> {
                    int min = Arrays.stream(matrix[i]).min().orElse(Integer.MIN_VALUE);
                    System.out.println("Row " + i + " -> " + min);
                });

        // Maximum in each column
        System.out.println("\nMaximum in each column:");
        int cols = matrix[0].length;
        IntStream.range(0, cols)
                .forEach(j -> {
                    int max = IntStream.range(0, matrix.length)
                            .map(i -> matrix[i][j])
                            .max()
                            .orElse(Integer.MIN_VALUE);
                    System.out.println("Column " + j + " -> " + max);
                });
    }

    public static Integer getMax(List<Integer> list) {
        return list.stream().max(Comparator.comparingInt(Integer::intValue)).get();
    }

    public static Integer getMin(List<Integer> list) {
        return list.stream().min(Comparator.comparingInt(Integer::intValue)).get();
    }
}
