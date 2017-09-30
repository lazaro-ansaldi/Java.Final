package sensefilms.exceptions;

public class LoggedException extends Exception
{

	private static final long serialVersionUID = 1L;
	
	private Exception ex;
	
	public LoggedException() 
	{
		super();
	}
	
	public LoggedException(String message) 
	{
		super(message);
	}
	
	public LoggedException(Exception ex) 
	{
		this.ex=ex;
	}
	
	public LoggedException(Exception ex, String message) 
	{
		super(message);
		this.ex=ex;
	}

}
