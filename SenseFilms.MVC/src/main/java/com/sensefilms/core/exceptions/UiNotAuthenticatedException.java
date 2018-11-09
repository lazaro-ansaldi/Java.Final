package com.sensefilms.core.exceptions;

public class UiNotAuthenticatedException extends UiException
{
	private static final long serialVersionUID = 1L;
	
	public UiNotAuthenticatedException() 
	{
		super();
	}
	
	public UiNotAuthenticatedException(String message) 
	{
		super(message);
	}

}
