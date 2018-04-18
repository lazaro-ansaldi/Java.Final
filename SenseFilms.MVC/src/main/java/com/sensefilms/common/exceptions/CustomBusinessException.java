package com.sensefilms.common.exceptions;

public class CustomBusinessException extends CustomHandledException
{
	private static final long serialVersionUID = 1L;
	
	public CustomBusinessException() 
	{
		super();
	}
	
	public CustomBusinessException(String message) 
	{
		super(message);
	}

}
