package com.prac.core.problem.date;

import java.time.LocalDate;
import java.time.Period;

public class CalculateAge {
    public static void main(String[] args) {
        LocalDate dob = LocalDate.of(1980,10,22);
        LocalDate today = LocalDate.now();
        Period period = Period.between(dob, today);
//        int yrs = Period.between(dob, today).getYears();
//        int mon = Period.between(dob, today).getMonths();
//        int days = Period.between(dob, today).getDays();

        System.out.println("Age: "+period.getYears()+" Years and "+period.getMonths()+" Months and "+period.getDays()+" Days");
    }
}
