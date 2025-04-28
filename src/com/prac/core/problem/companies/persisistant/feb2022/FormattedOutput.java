package com.prac.core.problem.companies.persisistant.feb2022;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FormattedOutput {

    public static void main(String[] args) {
        int val = 5;

        JDK5_Logic(val);
        JDK8_Logic(val);
    }

    public static void JDK5_Logic(int value) {
        int val = value;

        StringBuffer sb = new StringBuffer();
        for (int i = val; i > 0; i--) {
            String temp = "";
            int limit = val - i;
            for (int j = 0; j < (limit + 1); j++) {
                temp = temp + i;
            }
            sb.append(temp+" ");
        }
        System.out.println("JDK5_Logic : "+sb.toString());
    }


    public static void JDK8_Logic(int value) {
        int val = value;

        String result = IntStream.iterate(val, i -> i - 1)
                .limit(val)  // Loop from val down to 1
                .mapToObj(i ->
                        IntStream.rangeClosed(0, val - i)
                                .mapToObj(j -> String.valueOf(i))
                                .collect(Collectors.joining())
                )
                .collect(Collectors.joining(" "));

        System.out.println("JDK8_Logic1: "+result);

        String collected = IntStream.iterate(val, i -> i - 1)
                .limit(val)
                .mapToObj(m -> String.valueOf(m).repeat(val - m + 1))
                .collect(Collectors.joining(" "));
        System.out.println("JDK8_Logic2: "+collected);
    }
}

/*
  Accept a number from the user say 5 
  Then the output will be 544333222211111

*/
