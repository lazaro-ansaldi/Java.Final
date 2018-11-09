package com.sensefilms.core.extensions;

import java.text.SimpleDateFormat;

public class DateTimeExtensions 
{
	public static boolean tryParseToSqlDate(java.util.Date date, java.sql.Date sqlDate)
	{
		try 
		{
			sqlDate = new java.sql.Date(date.getTime());
			return true;
		}
		catch(Exception ex) 
		{
			return false;
		}
	}
	
	public static java.sql.Date parseToSqlDate(java.util.Date date)
	{
		return new java.sql.Date(date.getTime());
	}
	
	public static String toString(java.util.Date date, String format) 
	{
		return new SimpleDateFormat(format).format(date);
	}
}
