package com.prac.core.practice.stream.employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Department {

    private static final Random RANDOM = new Random();
    private static final List<DepartmentCode> DEPARTMENT_CODES = Collections.unmodifiableList(Arrays.asList(DepartmentCode.values()));
    private static final int SIZE = DEPARTMENT_CODES.size();

    public static String getRandomDepartmentCode(){
        return DEPARTMENT_CODES.get(RANDOM.nextInt(SIZE)).name();
    }

    public enum DepartmentCode {Admin, Finance, IT, Travel, Infra}
}
