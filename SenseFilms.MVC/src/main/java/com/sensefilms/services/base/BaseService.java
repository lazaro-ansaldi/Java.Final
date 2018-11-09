package com.sensefilms.services.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sensefilms.core.utilities.ITransformUtility;

public abstract class BaseService
{
	@Autowired
	protected ITransformUtility mapperUtility;
	private Logger logger;
	
	public BaseService(Class<? extends BaseService> clazz) 
	{
		this.logger = LoggerFactory.getLogger(clazz);
	}
	
	protected Logger getLogger() 
	{
		return this.logger;
	}
	
	protected ITransformUtility getTransformUtility() 
	{
		return mapperUtility;
	}
}
