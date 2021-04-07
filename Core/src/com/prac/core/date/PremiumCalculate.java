package com.prac.core.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PremiumCalculate {

	public static void main(String[] args) throws ParseException {
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		 String iDOB="1980-10-22";  
		 Date fDOB = formatter.parse(iDOB);
//		 System.out.println("DateOfBirth: "+fDOB);
		 System.out.println("  DOB: "+formatter.format(fDOB));
		 
		 Calendar c = Calendar.getInstance();
		 c.setTime(fDOB);
		 c.add(Calendar.YEAR, 40);
		 Date lapseDate = c.getTime();
//		 System.out.println("LapseDate: "+lapseDate);
		 System.out.println("Lapse: "+formatter.format(lapseDate));
		 
		 Date currDate = new Date();
		 System.out.println("Today: "+formatter.format(currDate));
//		 System.out.println("Today: "+currDate);
		 
		 System.out.println("");
		 if(currDate.after(lapseDate))
		        System.out.println("Policy is Lapsed");
		    else
		    	System.out.println("Policy is In-Force");
		 
	}

}
