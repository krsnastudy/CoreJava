package com.prac.core.jdk8.dateandtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateExample1 {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println("LocalDate Now: " + localDate);

		LocalTime localTime = LocalTime.now();
		System.out.println("LocalTime Now: " + localTime);

		int day = localDate.getDayOfMonth();
		int mon = localDate.getMonthValue();
		int year = localDate.getYear();
		System.out.printf("%d-%d-%d", day, mon, year);

		System.out.print(" ");
		int h = localTime.getHour();
		int m = localTime.getMinute();
		int s = localTime.getSecond();
		int n = localTime.getNano();
		System.out.printf("%d:%d:%d:%d", h, m, s, n);

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("\nLocalDateTime Now: " + localDateTime);

		int day1 = localDateTime.getDayOfMonth();
		int month1 = localDateTime.getMonthValue();
		int year1 = localDateTime.getYear();
		int h1 = localDateTime.getHour();
		int m1 = localDateTime.getMinute();
		int s1 = localDateTime.getSecond();
		int n1 = localDateTime.getNano();
		System.out.printf("LocalDateTime Formatted: %d-%d-%d", day1, month1, year1);
		System.out.println();
		System.out.printf("%d:%d:%d:%d", h1, m1, s1, n1);

		LocalDateTime ldt1 = LocalDateTime.of(1980, Month.OCTOBER, 22, 8, 45);
		System.out.println(ldt1);
	}

}
