package com.prac.core.jdk8.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting_Jdk8 {

	public static void main(String[] args) {
		DateTimeFormatter mmddyyy_Formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
		DateTimeFormatter ddmmmyyy_Formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

		// Local date instance
		LocalDate mmddyyy_localDate = LocalDate.now();

		// Get formatted String
		String mmddyyy_dateString = mmddyyy_Formatter.format(mmddyyy_localDate);

		System.out.println(" mmddyyy_Formatter: " + mmddyyy_dateString);
		System.out.println("ddmmmyyy_Formatter: " + ddmmmyyy_Formatter.format(mmddyyy_localDate));
	}

}
