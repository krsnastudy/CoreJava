package com.prac.core.problem.companies.wissen.jun2025;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LeastRepeatedWordChar {

    public static void main(String[] args) {

        String str = "This event isn't in your calendar yet You haven't interacted with this sender before. Do you want to automatically add this and future invitations from them to your calendar";
        System.out.println("Given String :: " + str);

//        str = str.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
//        System.out.println("Given String :: " + str);

        String[] stringArr = str.split(" ");

        Map<String, Long> collect = Arrays.stream(stringArr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(f -> f.getValue() == 1L)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Result:: " + collect);

        /*** Characters ***/
        String charString = str.replaceAll(" ", "").toLowerCase();
        Map<Character, Long> charMap = charString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Given:: " + charMap);

        String characterResult = charMap.entrySet().stream()
                .filter(f -> f.getValue() == 1L)
                .map(m -> m.getKey() + " -- " + m.getValue())
                .collect(Collectors.joining(", "));
        System.out.println("Result:: " + characterResult);
    }

}