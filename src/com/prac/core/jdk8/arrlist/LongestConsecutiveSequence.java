package com.prac.core.jdk8.arrlist;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int findLongestConsecutiveSequence_JDK5(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        for (int num : numSet) {
            // Check if num is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    public static int findLongestConsecutiveSequence_JDK8(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(HashSet::new, Set::add, Set::addAll);

        return numSet.stream()
                .filter(num -> !numSet.contains(num - 1)) // Start of a sequence
                .mapToInt(num -> {
                    int length = 1;
                    while (numSet.contains(num + length)) length++;
                    return length;
                })
                .max()
                .orElse(0);
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2, 5, 6};
        System.out.println("\n(JDK5)Longest consecutive sequence length: " + findLongestConsecutiveSequence_JDK5(nums));
        System.out.println("\n(JDK8)Longest consecutive sequence length: " + findLongestConsecutiveSequence_JDK8(nums));
    }
}