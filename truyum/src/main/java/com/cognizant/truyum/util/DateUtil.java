package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static Date convert(String date) {
		Date date1=null;
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date1=s.parse(date);
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		return date1;
	}
}
