package com.prac.core.problem.companies.wissen.jun2025;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringTwoDistinctChars {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);

            // If more than 2 distinct chars, shrink the window from the left
            while (charCount.size() > 2) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }

            // Update the maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s)); // Output: 3 ("ece")

        s = "ccaabbb";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s)); // Output: 5 ("aabbb")
    }
}