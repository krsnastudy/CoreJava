package com.prac.core.jdk8.arrlist;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class FindDuplicateChars {
    public static void main(String[] args) {
        String input="vivek kadiyan";
        List<String> duplicateCharacter = findDuplicateChracter(input);
        System.out.println("Duplicate character::::"+duplicateCharacter);
    }
    private static List<String> findDuplicateChracter(String input){

        List<Character> list = input.chars().mapToObj(o -> (char)o).collect(Collectors.toList());
        list.stream().filter(f -> Collections.frequency(list,f)>1).collect(Collectors.toList()).forEach(System.out::println);

        return Arrays.stream(input.split("")).collect(Collectors.groupingBy(ch->ch , Collectors.counting()))
                .entrySet().stream().filter(cha->cha.getValue()>1).map(in->in.getKey()).collect(Collectors.toList());
    }
}