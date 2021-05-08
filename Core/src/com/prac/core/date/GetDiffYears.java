package com.prac.core.date;

import java.util.Calendar;
import java.util.Date;

public class GetDiffYears {

	public static boolean isExpireSoon(Date expiryDate, int expireSoonDays) 
	{
	    System.out.println("ExpiryDate  " + expiryDate);
	 
	    Date currtDate = new Date();            
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(expiryDate);
	    cal.add(Calendar.DAY_OF_YEAR, -expireSoonDays);
	    Date expireSoonDate = cal.getTime();
	     
	    System.out.println("CurrentDate  "  + currtDate);
	    System.out.println("ExpirySoonDate  "  + expireSoonDate);
	     
	    if(currtDate.after(expireSoonDate) && currtDate.before(expiryDate))
	        return true;
	    else
	        return false;
	}
	    
	    public static void main(String[] args) 
	    {
	        Calendar calTest1 = Calendar.getInstance();
	        calTest1.add(Calendar.DAY_OF_YEAR, 31);
	        Date dateTest1 = calTest1.getTime();
	        System.out.println(isExpireSoon(dateTest1, 30));
	        
	        System.out.println();
	        
	        Calendar calTest2 = Calendar.getInstance();
	        calTest2.add(Calendar.DAY_OF_YEAR, 29);
	        Date dateTest2 = calTest2.getTime();
	        System.out.println(isExpireSoon(dateTest2, 30));
	    }
}
