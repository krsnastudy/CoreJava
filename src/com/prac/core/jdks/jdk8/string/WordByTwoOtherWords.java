package com.prac.core.jdks.jdk8.string;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class WordByTwoOtherWords {
    public static void main(String[] args) {
        String[] str = {"cat", "dog", "catdog", "hat"};

        Set<String> hSet1 = new LinkedHashSet<>();
        for(int i=0; i< str.length; i++){
            for(int j=0; (j<str.length); j++){
                hSet1.add(str[i]+str[j]);
            }
        }
        System.out.println("HashSet:: "+hSet1);
        Arrays.stream(str)
                .filter(f->hSet1.contains(f))
                .toList()
                .forEach(System.out::println);
        ;
    }
}
