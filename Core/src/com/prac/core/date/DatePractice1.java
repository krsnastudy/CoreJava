package com.prac.core.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class DatePractice1 {

	public static void main(String[] args) {

		LocalDate localDate = LocalDate.now().plusDays(1);
		System.out.println("Local Date: "+localDate);
		System.out.println(LocalDate.of(2015, 02, 20));
		System.out.println(LocalDate.parse("2018-04-20"));
		
		LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
		System.out.println("previousMonthSameDay: "+previousMonthSameDay);
		
		DayOfWeek getDayOfWeek = LocalDate.parse("2016-06-12").getDayOfWeek();
		int getDayOfMonth = LocalDate.parse("2016-06-12").getDayOfMonth();
		
		System.out.println("getDayOfWeek: "+getDayOfWeek);
		System.out.println("getDayOfMonth:"+getDayOfMonth);
		
		boolean isLeapYear = LocalDate.now().isLeapYear();
		System.out.println("isLeapYear:"+isLeapYear);
		
		boolean notBefore = LocalDate.parse("2016-06-12")
				  .isBefore(LocalDate.parse("2016-06-11"));
		System.out.println("notBefore:"+notBefore);
		
				boolean isAfter = LocalDate.parse("2016-06-12")
				  .isAfter(LocalDate.parse("2016-06-11"));
		System.out.println("isAfter:"+isAfter);
		
		LocalTime localTime = LocalTime.now();
		LocalTime maxTime = LocalTime.MAX;
		System.out.println("Max Time: "+maxTime);
		
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		System.out.println("Total Zones Size: "+allZoneIds.size());
//		System.out.println("allZoneIds: "+allZoneIds);	
		//allZoneIds.forEach(System.out::println);
		
		LocalDate localDateTime = LocalDate.now();
		localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		System.out.println("localDateTime: "+localDateTime);
	}

}
