package com.prac.core.problem.companies.wissen.jun2025;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraySplitter {
    public static int[][] splitArray(int[] array, int chunkSize) {

        System.out.println("Given Array :: "+Arrays.toString(array)+"\n");
        return IntStream.range(0, (array.length + chunkSize - 1) / chunkSize)
                        .peek(p-> System.out.println("Iteration "+p+" --> Start Position:: "+p*chunkSize+" -- End Position:: "+Math.min(array.length, (p + 1) * chunkSize)))
                        .mapToObj(i -> Arrays.copyOfRange(array,i * chunkSize,Math.min(array.length, (i + 1) * chunkSize)))
                        .peek(p-> System.out.println("Row Values :: "+Arrays.toString(p)))
                        .toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int chunkSize = 2;

        int[][] chunks = splitArray(originalArray, chunkSize);
        System.out.println("\n:: Final OUTPUT ::");
        for (int[] chunk : chunks) {
            System.out.println(Arrays.toString(chunk));
        }
    }
}

/*
*
*     public static long[] copyOfRange(long[] original, int from, int to) {

Copies the specified range of the specified array into a new array. The initial index of the range (from) must lie between zero and original.length, inclusive.
The value at original[from] is placed into the initial element of the copy (unless from == original.length or from == to).
Values from subsequent elements in the original array are placed into subsequent elements in the copy. The final index of the range (to),
which must be greater than or equal to from, may be greater than original.length,
in which case 0 is placed in all elements of the copy whose index is greater than or equal to original.length - from.
The length of the returned array will be to - from.

* Params: *
original – the array from which a range is to be copied
from – the initial index of the range to be copied, inclusive
to – the final index of the range to be copied, exclusive. (This index may lie outside the array.)
Returns: a new array containing the specified range from the original array, truncated or padded with zeros to obtain the required length
* */