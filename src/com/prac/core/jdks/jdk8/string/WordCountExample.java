package com.prac.core.jdks.jdk8.string;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCountExample {

    public static void main(String[] args) {
        String[] sentences = {
                "Java is great and Java is powerful",
                "Spring Boot makes Java development easy"
        };

        Map<String, Long> wordCount = Arrays.stream(sentences) // Stream<String> of sentences
                .flatMap(sentence -> Arrays.stream(sentence.toLowerCase().split("\\s+"))) // split each sentence into words, flatten
                .map(word -> word.replaceAll("[^a-z0-9]", "")) // strip punctuation
                .filter(word -> !word.isEmpty()) // guard against empty tokens
                .collect(Collectors.groupingBy(word -> word, Collectors.counting())); // group + count

        // Print sorted by frequency (descending)
        wordCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }
}