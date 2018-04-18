package com.sensefilms.web.controllers.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public abstract class BaseController 
{

	private Logger logger;
	
	public BaseController(Class<? extends BaseController> clazz) 
	{
		this.logger = LoggerFactory.getLogger(clazz);	
	}
	
	public BaseController() 
	{
		
	}
	
	protected Logger getLogger() 
	{
		return this.logger;
	}
}
