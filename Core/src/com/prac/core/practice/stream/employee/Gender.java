package com.prac.core.practice.stream.employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Gender {
    private static final Random RANDOM = new Random();

    private static final List<Gender.GenderCode> GENDER_CODES = Collections.unmodifiableList(Arrays.asList(Gender.GenderCode.values()));
    private static final int SIZE = GENDER_CODES.size();

    public static String getRandomGenderCode(){
        return GENDER_CODES.get(RANDOM.nextInt(SIZE)).name();
    }

    public enum GenderCode{Male, Female, Transgender}
}
