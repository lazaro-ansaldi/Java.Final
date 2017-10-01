package sensefilms.helpers;

import java.text.SimpleDateFormat;

public class DateTimeHelper 
{
	public static boolean TryParseToSqlDate(java.util.Date date, java.sql.Date sqlDate)
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
	
	public static java.sql.Date ParseToSqlDate(java.util.Date date)
	{
		return new java.sql.Date(date.getTime());
	}
	
	public static String ToString(java.util.Date date, String format) 
	{
		return new SimpleDateFormat(format).format(date);
	}
}
