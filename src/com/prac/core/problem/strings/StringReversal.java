package com.prac.core.problem.strings;

public class StringReversal {

    public static void main(String[] args) {
        String str = "This is String Reverse Program";

        char[] cArr = str.toCharArray();
        int i = 0;
        int j = cArr.length - 1;

        while (i < j) {
            swap(cArr, i, j);
            i++;
            j--;
        }

        System.out.println("        String: " + str);
        System.out.println("Reverse String: " + String.valueOf(cArr));
        StringBuffer sb = new StringBuffer(str);
        System.out.println("Reverse StringBuffer: " + sb.reverse());
        reverse(str);
    }

    private static void swap(char[] cArr, int i, int j) {
        char t = cArr[i];
        cArr[i] = cArr[j];
        cArr[j] = t;
    }

    static void reverse(String str) {
        if ((str == null) || (str.length() <= 1))
            System.out.println(str);
        else {
            System.out.print(str.charAt(str.length() - 1));
            reverse(str.substring(0, str.length() - 1));
        }
    }
}
