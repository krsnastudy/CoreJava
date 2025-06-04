package com.prac.core.jdks.jdk8.string;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseStringKeepSpecialChars {
    public static void main(String[] args) {

        System.out.println(reverseKeepingSpecialChars("a@bc$d"));
    }

    public static String reverseKeepingSpecialChars(String input) {
        char[] cArr = input.toCharArray();
        int left =0;
        int right = cArr.length-1;

        while (left<right){
            if(!Character.isLetter(cArr[left])){
                left++;
            }else if(!Character.isLetter(cArr[right])){
                right--;
            }else{
                char temp = cArr[left];
                cArr[left] = cArr[right];
                cArr[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println(Arrays.toString(cArr));
        return String.valueOf(cArr);
    }


    public static String reverseKeepingSpecialChars_JDK8(String input) {
        char[] chars = input.toCharArray();
        int[] left = {0};
        int[] right = {chars.length - 1};

        IntStream.range(0, chars.length / 2)
                .forEach(i -> {
                    while (left[0] < right[0] && !Character.isLetter(chars[left[0]])) {
                        left[0]++;
                    }
                    while (left[0] < right[0] && !Character.isLetter(chars[right[0]])) {
                        right[0]--;
                    }
                    if (left[0] < right[0]) {
                        char temp = chars[left[0]];
                        chars[left[0]] = chars[right[0]];
                        chars[right[0]] = temp;
                        left[0]++;
                        right[0]--;
                    }
                });
        return new String(chars);
    }
}
