package com.prac.core.jdks.jdk11.string;

import java.util.stream.Collectors;

public class Jdk11_String {
    public static void main(String[] args) {
        String str1isBlank = "";
        System.out.println("isBlank(): " + str1isBlank.isBlank());

        String str2isBlank = "GeeksForGeeks";
        System.out.println("isBlank(): " + str2isBlank.isBlank());

        String strLines = "Geeks\nFor\nGeeks";
        System.out.println("lines(): " + strLines.lines().collect(Collectors.toList()));

        String strRepeat = "GeeksForGeeks";
        System.out.println("repeat() " + strRepeat.repeat(4));

        String stripLeading = " GeeksForGeeks";
        System.out.println("stripLeading: " + stripLeading.stripLeading());

        String stripTrailing = "GeeksForGeeks ";
        System.out.println("stripTrailing: " + stripTrailing.stripTrailing());

        String strStrip = " GeeksForGeeks ";
        System.out.println("strip: " + strStrip.strip());
    }
}


/**
 * New String Methods
 * <p>
 * isBlank(): This is a boolean method. It just returns true when a string is empty and vice-versa.
 * lines(): This method is to return a collection of strings that are divided by line terminators.
 * repeat(n): Result is the concatenated string of original string repeated the number of times in the argument.
 * stripLeading(): It is used to remove the white space which is in front of the string
 * stripTrailing(): It is used to remove the white space which is in the back of the string
 * strip(): It is used to remove the white spaces which are in front and back of the string
 **/