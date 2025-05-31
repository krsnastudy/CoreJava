package com.prac.core.problem.companies.veear.may2025;

import java.util.Arrays;
import java.util.List;

public class Conversions {
    public static void main(String[] args) throws Exception {

        System.out.println("String ak --> " + ConvertString_To_Long("ak"));
        System.out.println("String 50 --> " + ConvertString_To_Long("50"));

        List<Long> longList = Arrays.asList(10L, 99L, 1L, 23L, 65L, 47L, 34L, 28L, 95L, 56L, 18L);
        System.out.println("List to Array :: " + Arrays.toString(ConvertListLong_To_longArray(longList)));
    }

    private static Long ConvertString_To_Long(String itemId) throws Exception {
        try {
            return Long.parseLong(itemId);
        } catch (NumberFormatException NFE) {
            return Long.valueOf(0L);
        }
    }

    private static long[] ConvertListLong_To_longArray(List<Long> itemIds) throws Exception {
//        return itemIds;

        if (itemIds == null) {
            throw new Exception("Input list cannot be null");
        }

        long[] result =
                itemIds.stream()
                        .mapToLong(Long::longValue) // Convert to primitive long
                        .toArray();                 // Collect to long[]

        //Sorting         Arrays.sort(result);

        return result;
    }


}




/*
// Resolve these errors
private Long ConvertString_To_Long(String itemId) throws Exception {
	return itemId;
}

private long[] ConvertListLong_To_longArray(List<Long> itemIds) throws Exception {
	return itemIds;
}
*/