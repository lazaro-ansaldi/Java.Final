package sensefilms.helpers;

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
}
