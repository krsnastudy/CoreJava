package com.prac.core.problem.date;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class CalculateAge {
    public static void main(String[] args) {

        Function<LocalDate, Period> function = bDate -> Period.between(bDate, LocalDate.now());
        BiConsumer<String, Period> printAge = (name, age) -> System.out.println(name + " Age as of Today is " + age.getYears() + " Years and " + age.getMonths() + " Months and " + age.getDays() + " Days");

        LocalDate dob = LocalDate.of(1980, 10, 22);
        LocalDate today = LocalDate.now();
        Period period = Period.between(dob, today);
//        System.out.println("Age: " + period.getYears() + " Years and " + period.getMonths() + " Months and " + period.getDays() + " Days");

        LocalDate krsnaDOB = LocalDate.of(1980, 10, 22);
        LocalDate nirmalaDOB = LocalDate.of(1984, 6, 13);
        LocalDate saatvikDOB = LocalDate.of(2015, 12, 14);

        System.out.println("\n");
        printAge.accept("Krishna", function.apply(krsnaDOB));
        printAge.accept("Nirmala", function.apply(nirmalaDOB));
        printAge.accept("Saatvik", function.apply(saatvikDOB));

    }
}
