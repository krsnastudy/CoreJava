package com.prac.core.problem.gen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {
    //function to construct the largest number
    public static String findLargestNumber(List<Integer> nums) {
//sort using a custom function object
        Collections.sort(nums, (a, b) -> (String.valueOf(b) + a).compareTo(String.valueOf(a) + b));
        return nums.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    //driver code
    public static void main(String args[]) {
//defining an array from which we have to construct largest number
        List<Integer> numbers = Arrays.asList(7, 58, 87, 2, 16, 34, 54, 0, 90);
//stores the largest number
        String largestNumber = findLargestNumber(numbers);
//prints the largest number
        System.out.println("The largest number is: " + largestNumber);
    }
}