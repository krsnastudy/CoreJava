package com.prac.core.jdk8.date;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateJdk8 {

	public static void main(String[] args) {

		LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
		// System.out.println("previousMonthSameDay: "+previousMonthSameDay);

		LocalDate today = LocalDate.now();
		// add 1 month to the current date
		LocalDate cMonth = today.plus(-1, ChronoUnit.MONTHS);
		// System.out.println("Prev month: " + cMonth);

		String str = "2015-01-31";
		Date date = Date.valueOf(str);// converting string into sql date

		Date sDate = convertToDatabaseColumn(cMonth);
		System.out.println("Main Sql Date: " + sDate);

		LocalDate lDate = convertToEntityAttribute(date);
		lDate = lDate.plus(-1, ChronoUnit.MONTHS);
		System.out.println("Main Local Date: " + lDate);
	}

	public static Date convertToDatabaseColumn(LocalDate locDate) {
		System.out.println("Sql Date: " + Date.valueOf(locDate));
		return (locDate == null ? null : Date.valueOf(locDate));
	}

	public static LocalDate convertToEntityAttribute(Date sqlDate) {
		System.out.println("Local Date: " + sqlDate.toLocalDate());
		return (sqlDate == null ? null : sqlDate.toLocalDate());
	}

}
