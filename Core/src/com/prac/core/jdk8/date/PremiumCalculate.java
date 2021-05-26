package com.prac.core.jdk8.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PremiumCalculate {

	public static void main(String[] args) throws ParseException {
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		 String iDOB="1980-10-10";  
		 Date fDOB = formatter.parse(iDOB);
//		 System.out.println("DateOfBirth: "+fDOB);
		 System.out.println("  DOB: "+formatter.format(fDOB));
		 
		 Calendar c = Calendar.getInstance();
		 c.setTime(fDOB);
		 c.add(Calendar.YEAR, 15);
		 Date lapseDate = c.getTime();
//		 System.out.println("LapseDate: "+lapseDate);
		 System.out.println("DOB+Term: "+formatter.format(lapseDate));
		 
		 Date currDate = new Date();
		 System.out.println("Today: "+formatter.format(currDate));
//		 System.out.println("Today: "+currDate);
		 
		 Calendar todayDate = Calendar.getInstance();
		 todayDate.setTime(new Date());
		 todayDate.add(Calendar.YEAR, -70);
		 Date policyDate = todayDate.getTime();
//		 System.out.println("policyDate: "+policyDate);
		 System.out.println("policyDate: "+formatter.format(policyDate));
		 
		 System.out.println(currDate.getTime()-lapseDate.getTime());
		 System.out.println(policyDate.getTime()-lapseDate.getTime());
		 
		 if(policyDate.before(fDOB))
		        System.out.println("Policy is Lapsed");
		    else
		    	System.out.println("Policy is In-Force");
	}

}
