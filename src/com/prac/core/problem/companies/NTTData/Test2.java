package com.prac.core.problem.companies.NTTData;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {

        Integer array[] = {1, 1, 0, 1, 0};
        List<Integer> collect = Arrays.stream(array)
                .sorted(Comparator.comparingInt(Integer::valueOf))
                .collect(Collectors.toList());

        System.out.println(collect);

        int[] iArray = {2, 3, 0, 4, 1, 0, 7};
        int[] iResArray = new int[iArray.length];
        int counter = 0;

        for (int i = 0; i < iArray.length; i++) {
            if (iArray[i] != 0) {
                iResArray[counter] = iArray[i];
                counter++;
            }
        }

        System.out.println(Arrays.toString(iArray));
        System.out.println(Arrays.toString(iResArray));

        // Filter non-zero elements using Java 8 Stream
        int[] nonZero = Arrays.stream(iArray)
                .filter(n -> n != 0)
                .toArray();

        // Create result array of original size, fill non-zeros in front
        int[] oArray = new int[iArray.length];
        System.arraycopy(nonZero, 0, oArray, 0, nonZero.length);

        System.out.println(Arrays.toString(oArray));

    }
}

/* *
 * array[] = [2,3,0,4,1,0,7]
 *op:[2,3,4,1,7,0,0]
* */
