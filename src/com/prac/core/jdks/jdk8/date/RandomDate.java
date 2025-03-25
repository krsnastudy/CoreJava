package com.prac.core.jdks.jdk8.date;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDate {
    public static void main(String[] args) {

        LocalDate localDate = between(LocalDate.of(2020, 01, 01), LocalDate.of(2023, 12, 31));
        System.out.println("Dynamic Date: "+localDate);
    }

    public static LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
//        long startEpochDay = startInclusive.toEpochDay();
//        long endEpochDay = endExclusive.toEpochDay();

        int dayRandom = new Random().nextInt(1, 30);
        int monRandom = new Random().nextInt(1, 12);
        int yearRandom = new Random().nextInt(1, 24);
//        System.out.println("dayRandom: "+dayRandom+", monRandom: "+monRandom+", yearRandom: "+yearRandom);

        LocalDate today = LocalDate.now();
        startInclusive = today.minusYears(yearRandom).minusMonths(monRandom).minusDays(dayRandom);
        System.out.println("   StartDate: "+startInclusive);
        endExclusive = today.minusDays(1);
        System.out.println("     EndDate: "+endExclusive);

        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();

        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }
}
