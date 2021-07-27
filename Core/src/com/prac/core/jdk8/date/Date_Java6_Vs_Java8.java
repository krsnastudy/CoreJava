package com.prac.core.jdk8.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Date_Java6_Vs_Java8 {

	public static void main(String[] args) throws ParseException, InterruptedException {

//		Getting current time

		// Old
		Date currentTime_Jdk6 = new Date();

		// New
		ZonedDateTime currentTime_Jdk8 = ZonedDateTime.now();

		System.out.println(currentTime_Jdk6 + " {Getting current time} " + currentTime_Jdk8);

//		Representing specific time

		// Old
		Date birthDay_Jdk6 = new GregorianCalendar(1980, Calendar.OCTOBER, 22).getTime();

		// New
		LocalDate birthDay_Jdk8 = LocalDate.of(1980, Month.OCTOBER, 22);

		System.out.println(birthDay_Jdk6 + " {Representing specific time} " + birthDay_Jdk8);

//		Extracting specific fields

		// Old
		int month_Jkd6 = new GregorianCalendar().get(Calendar.MONTH);

		// New
		Month month_Jdk8 = LocalDateTime.now().getMonth();

		System.out.println(month_Jkd6 + " {Extracting specific fields} " + month_Jdk8);

//		Adding and subtracting time

		// Old
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.add(Calendar.HOUR_OF_DAY, -5);
		Date fiveHoursBefore_Jdk6 = calendar.getTime();

		// New
		LocalDateTime fiveHoursBefore_Jdk8 = LocalDateTime.now().minusHours(5);

		System.out.println(fiveHoursBefore_Jdk6 + " {Adding and subtracting time} " + fiveHoursBefore_Jdk8);

//		Altering specific fields

		// Old
		GregorianCalendar calendarAlter = new GregorianCalendar();
		calendarAlter.set(Calendar.MONTH, Calendar.JUNE);
		Date inJune_Jdk6 = calendarAlter.getTime();

		// New
		LocalDateTime inJune_Jdk8 = LocalDateTime.now().withMonth(Month.JUNE.getValue());

		System.out.println(inJune_Jdk6 + " {Altering specific fields} " + inJune_Jdk8);

		/*
		 * Truncating resets all time fields smaller than the specified field. In the
		 * example below minutes and everything below will be set to zero
		 */

		// Old
		Calendar truncating_now = Calendar.getInstance();
		truncating_now.set(Calendar.MINUTE, 0);
		truncating_now.set(Calendar.SECOND, 0);
		truncating_now.set(Calendar.MILLISECOND, 0);
		Date truncated_Jdk6 = truncating_now.getTime();

		// New
		LocalTime truncated_Jdk8 = LocalTime.now().truncatedTo(ChronoUnit.HOURS);

		System.out.println(truncated_Jdk6 + " {Truncating specific fields} " + truncated_Jdk8);

//		Time zone conversion

		// Old
		GregorianCalendar calendar_timezone = new GregorianCalendar();
		calendar_timezone.setTimeZone(TimeZone.getTimeZone("CET"));
		Date centralEastern_Jdk6 = calendar_timezone.getTime();

		// New
		ZonedDateTime centralEastern_Jdk8 = LocalDateTime.now().atZone(ZoneId.of("CET"));

		System.out.println(centralEastern_Jdk6 + " {Time zone conversion} " + centralEastern_Jdk8);

//		Getting time span between two points in time

		// Old
		GregorianCalendar calendar_timeSpan = new GregorianCalendar();
		Date now_Jdk6 = new Date();
		calendar_timeSpan.add(Calendar.HOUR, 1);
		Date hourLater_Jdk6 = calendar_timeSpan.getTime();
		long elapsed_Jdk6 = hourLater_Jdk6.getTime() - now_Jdk6.getTime();

		// New
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime hourLater = LocalDateTime.now().plusHours(1);
		Duration span = Duration.between(now, hourLater);

		System.out.println(elapsed_Jdk6 + " {Getting time span} " + span);

//		Time formatting and parsing
		/*
		 * DateTimeFormatter is a replacement for the old SimpleDateFormat that is
		 * thread-safe and provides additional functionality.
		 */

		// Old
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date now_sdf = new Date();
		String formattedDate = dateFormat.format(now_sdf);
		Date parsedDate_Jdk6 = dateFormat.parse(formattedDate);

		// New
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate now_ld = LocalDate.now();
		String formatterDate = now_ld.format(formatter);
		LocalDate parsedDate_Jdk8 = LocalDate.parse(formatterDate, formatter);

		System.out.println(parsedDate_Jdk6 + " {Time formatting and parsing} " + parsedDate_Jdk8);

//		Number of days in a month

		// Old
		Calendar calendar_daysInaMonth = new GregorianCalendar(1990, Calendar.FEBRUARY, 20);
		int daysInMonth_Jdk6 = calendar_daysInaMonth.getActualMaximum(Calendar.DAY_OF_MONTH);

		// New
		int daysInMonth_Jdk8 = YearMonth.of(1990, 2).lengthOfMonth();

		System.out.println(daysInMonth_Jdk6 + " {Number of days in a month} " + daysInMonth_Jdk8);
		
		System.out.println();
		LocalDateTime start = LocalDateTime.now();
		Thread.sleep(25000);
		LocalDateTime end = LocalDateTime.now();
		
		long duration = ChronoUnit.SECONDS.between(end, start);
		System.out.println("start: "+start+"  "+"end: "+end);
		System.out.println(duration + " Seconds");
		
		LocalDateTime from = LocalDateTime.of(2020, 10, 4, 10, 20, 55);
        LocalDateTime to = LocalDateTime.of(2020, 11, 10, 10, 21, 1);
		System.out.println("start: "+from+"  "+"end: "+to);
		
		long years = ChronoUnit.YEARS.between(from, to);
        long months = ChronoUnit.MONTHS.between(from, to);
        long weeks = ChronoUnit.WEEKS.between(from, to);
        long days = ChronoUnit.DAYS.between(from, to);
        long hours = ChronoUnit.HOURS.between(from, to);
        long minutes = ChronoUnit.MINUTES.between(from, to);
        long seconds = ChronoUnit.SECONDS.between(from, to);
        long milliseconds = ChronoUnit.MILLIS.between(from, to);
        long nano = ChronoUnit.NANOS.between(from, to);

        System.out.println(years + " years");
        System.out.println(months + " months");
        System.out.println(weeks + " weeks");
        System.out.println(days + " days");
        System.out.println(hours + " hours");
        System.out.println(minutes + " minutes");
        System.out.println(seconds + " seconds");
        System.out.println(milliseconds + " milliseconds");
        System.out.println(nano + " nano");
	}
}

/*
 * 
 * https://www.baeldung.com/migrating-to-java-8-date-time-api
 * 
 * 1.2. API Flexibility
 * 
 * Another advantage is flexibility – working with multiple representations of
 * time. The old date library included only a single time representation class –
 * java.util.Date, which despite its name, is actually a timestamp. It only
 * stores the number of milliseconds elapsed since the Unix epoch.
 * 
 * The new API has many different time representations, each suitable for
 * different use cases:
 * 
 
Instant – represents a point in time (timestamp)
LocalDate – represents a date (year, month, day)
LocalDateTime – same as LocalDate, but includes time with nanosecond precision
OffsetDateTime – same as LocalDateTime, but with time zone offset
LocalTime – time with nanosecond precision and without date information
ZonedDateTime – same as OffsetDateTime, but includes a time zone ID
OffsetLocalTime – same as LocalTime, but with time zone offset
MonthDay – month and day, without year or time
YearMonth – month and year, without day or time
Duration – amount of time represented in seconds, minutes and hours. Has nanosecond precision
Period – amount of time represented in days, months and years 
 
 
https://mkyong.com/java8/java-8-difference-between-two-localdate-or-localdatetime/ 
 */