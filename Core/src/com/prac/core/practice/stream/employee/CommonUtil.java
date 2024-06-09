package com.prac.core.practice.stream.employee;

import java.time.LocalDate;

public class CommonUtil {
    public static int getYear(LocalDate doj) {
        return doj.getYear();
    }

    public static int getMonth(LocalDate doj){
        return doj.getMonth().getValue();
    }

    public static int getDay(LocalDate doj){
        return doj.getDayOfMonth();
    }
}
