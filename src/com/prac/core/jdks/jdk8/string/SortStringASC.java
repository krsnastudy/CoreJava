package com.prac.core.jdks.jdk8.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortStringASC {
    public static void main(String[] args) {
        String sentence = "I went through Mrs Shears’ gate, closing it behind me. I walked onto her lawn and knelt beside the dog. I put my hand on the muzzle of the dog. It was still warm.";
//        sentence = sentence.toLowerCase();
        System.out.println("B4 Sorted :: "+sentence);
        System.out.println("A4 Sorted :: "+Arrays.stream(sentence.split("\\s+")).sorted(Comparator.comparing(String::valueOf)).collect(Collectors.joining(" ")));
        String sortedSentence = Arrays.stream(sentence.split("\\s+")).sorted(String.CASE_INSENSITIVE_ORDER).reduce((x,y)->x+" "+y).orElse("");
        System.out.println("B4 Sorted1:: "+sortedSentence);

    }
}
