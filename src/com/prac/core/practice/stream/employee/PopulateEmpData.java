package com.prac.core.practice.stream.employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SuppressWarnings("unused")
public class PopulateEmpData {

    public PopulateEmpData(){

    }

    public static List<Employee> populateEmployeeData(int recordsCount){

        Random rSal = new Random();
        Random rPC = new Random();
        Random rEno = new Random();
        int minEno = 100000;
        int maxEno = 9999999;
        int minPin = 500000;
        int maxPin = 999999;

        return (ArrayList<Employee>) IntStream.rangeClosed(1, recordsCount)
                .mapToObj(i->
                        new Employee(
                                randomString(10),
                                randomString(5),
                                rEno.ints(minEno, maxEno).findFirst().getAsInt(),
//                                (rSal.nextFloat(9999, 99999)),
                                Float.valueOf((rSal.nextFloat(9999, 99999))),
                                rPC.ints(minPin, maxPin).findFirst().getAsInt(),
                                Department.getRandomDepartmentCode(),
                                dateOfJoining(),
                                Gender.getRandomGenderCode())
                )
                .collect(Collectors.toList());

    }

    public static String randomString(int length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        // System.out.println(generatedString);

        // get First letter of the string
        String firstLetStr = generatedString.substring(0, 1);
        // Get remaining letter using substring
        String remLetStr = generatedString.substring(1);

        // convert the first letter of String to uppercase
        firstLetStr = firstLetStr.toUpperCase();

        // concantenate the first letter and remaining string
        generatedString = firstLetStr + remLetStr;

        return generatedString;
    }

    public static LocalDate dateOfJoining() {
        int dayRandom = new Random().nextInt(1, 30);
        int monRandom = new Random().nextInt(1, 12);
        int yearRandom = new Random().nextInt(1, 24);
//        System.out.println("dayRandom: "+dayRandom+", monRandom: "+monRandom+", yearRandom: "+yearRandom);

        LocalDate today = LocalDate.now();
        LocalDate startInclusive = today.minusYears(yearRandom).minusMonths(monRandom).minusDays(dayRandom);
        LocalDate endExclusive = today.minusDays(1);

//        System.out.println("   StartDate: "+startInclusive);
//        System.out.println("     EndDate: "+endExclusive);

        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();

        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }
}