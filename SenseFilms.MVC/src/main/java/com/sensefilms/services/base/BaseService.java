package com.sensefilms.services.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseService
{

	private Logger logger;
	
	public BaseService(Class<? extends BaseService> clazz) 
	{
		this.logger = LoggerFactory.getLogger(clazz);
	}
	
	protected Logger getLogger() 
	{
		return this.logger;
	}
}
