package com.prac.core.jdk8.date;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class SqlToLocalDate {

	public static void main(String[] args) {

		String strDate = "2020-03-31";
		Date sqlDate = Date.valueOf(strDate);
		
//		sqlDate = sqlDate.add(Calendar.MONTH, -1);
		
		LocalDate lDate = sqlDate.toLocalDate();
		lDate = lDate.plus(-1, ChronoUnit.MONTHS);
		
		System.out.println("Sql Date: "+sqlDate);
		System.out.println("Local date: "+lDate);
		
		Date newSqlDate = Date.valueOf(lDate);
		System.out.println("newSqlDate date: "+newSqlDate);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(Date.valueOf(strDate));
		//c.add(Calendar.YEAR, -1); //one year back
		c.add(Calendar.MONTH, -1);// then one month
		System.out.println("SqlDate: "+dateFormat.format(c.getTime()));
	}

}
