package com.sensefilms.common.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UiException extends Exception
{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UiException.class);
	
	public UiException() 
	{
		super();
	}
	
	public UiException(Exception ex) 
	{
		super(ex);
		handleException(ex);		
	}
	
	public UiException(String message, Exception ex) 
	{
		super(message, ex);
		handleException(ex);	
	}
	
	public UiException(String message) 
	{
		super(message);
	}
	
	private void handleException(Exception ex) 
	{
		logger.error("Error message: " + ex.getMessage());
		logger.error("Stack trace: " + ex.getStackTrace());
		
		for(Throwable innerEx : ex.getSuppressed()) 
		{
			logger.error("Supressed message: " + innerEx.getMessage());
			logger.error("Supressed stack: " + innerEx.getStackTrace());
		}
	}

}
