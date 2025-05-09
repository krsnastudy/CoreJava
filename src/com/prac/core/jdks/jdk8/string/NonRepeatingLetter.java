package com.prac.core.jdks.jdk8.string;

import java.util.LinkedHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatingLetter {
    public static void main(String[] args) {

        String str = "zzzzzbbbccccddehhhhiii";

//        findFirstNonRepeatingLetter(args[0], System.out::println);
        findFirstNonRepeatingLetter(str, System.out::println);
        findFirstNonRepeatingChar(str);
        findFirstNonRepeatingLetter(str);
    }

    /* Java 8 */
    private static void findFirstNonRepeatingLetter(String s, Consumer callback) {
        s.chars().mapToObj(i -> Character.valueOf((char) i))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .map(c -> {
                    callback.accept(c);
                    return c;
                });
    }

    /* Java 7 */
    public static void findFirstNonRepeatingChar(String str) {

        int[] countingArray = new int[128];

        str.chars().forEach(j -> countingArray[j]++);

//		System.out.println(Arrays.toString(countingArray));

        int nonRepeatingCharAsInt = 0;

        for (int i = 0; i < countingArray.length; i++) {
            if (countingArray[i] == 1) {
                nonRepeatingCharAsInt = i;
                break;
            }
        }
        System.out.println("First Non-Repeating Character = " + Character.valueOf((char) nonRepeatingCharAsInt));

    }

    private static void findFirstNonRepeatingLetter(String str) {

        char c = str.chars()
                .mapToObj(i -> Character.valueOf((char) i))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> (entry.getValue() == 1L))
                .findFirst()
                .map(k -> k.getKey())
                .get();

        System.out.println(c);


		/*
		* Character c1 = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(f -> f.getValue() == 1).findFirst().get().getKey();

        System.out.println(c1);
		* */
    }
}