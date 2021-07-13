package com.prac.core.jdk8.dateandtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateExample1 {

	public static void main(String[] args) {
		LocalDate ld1 = LocalDate.now();
		System.out.println("LocalDate Now: "+ld1);
		
		LocalTime lt1 = LocalTime.now();
		System.out.println("LocalTime Now: "+lt1);
		
		int day = ld1.getDayOfMonth();
		int mon = ld1.getMonthValue();
		int year = ld1.getYear();
		System.out.printf("%d-%d-%d", day, mon, year);
		
		System.out.print(" ");
		int h = lt1.getHour();
		int m = lt1.getMinute();
		int s = lt1.getSecond();
		int n = lt1.getNano();
		System.out.printf("%d:%d:%d:%d", h, m, s, n);
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("\nLocalDateTime Now: "+ldt);
		
		int day1 = ldt.getDayOfMonth();
		int month1 = ldt.getMonthValue();
		int year1 = ldt.getYear();
		int h1 = ldt.getHour();
		int m1 = ldt.getMinute();
		int s1 = ldt.getSecond();
		int n1 = ldt.getNano();
		System.out.printf("LocalDateTime Formatted: %d-%d-%d",  day1, month1, year1);
		System.out.printf("%d:%d:%d:%d", h1, m1, s1, n1);
		
		LocalDateTime ldt1 = LocalDateTime.of(1980, Month.OCTOBER, 22, 8, 45);
		System.out.println(ldt1);
	}

}
