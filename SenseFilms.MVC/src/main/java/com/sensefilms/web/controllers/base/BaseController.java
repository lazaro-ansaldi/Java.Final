package com.sensefilms.web.controllers.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.sensefilms.common.exceptions.CustomHandledException;
import com.sensefilms.common.utils.StringUtils;
import com.sensefilms.common.exceptions.CustomBusinessException;
import com.sensefilms.web.support.ViewsResources;
import com.sensefilms.web.support.WebModelConstants;

@Controller
public abstract class BaseController 
{

	private Logger logger;
	
	public BaseController(Class<? extends BaseController> clazz) 
	{
		this.logger = LoggerFactory.getLogger(clazz);	
	}
	
	protected Logger getLogger() 
	{
		return this.logger;
	}
	
	protected ModelAndView handleException(CustomHandledException exception) 
	{
		return new ModelAndView(ViewsResources.ERROR_VIEW, WebModelConstants.ERROR_MESSAGE, exception.getMessage());
	}
	
	protected ModelAndView handleException(CustomBusinessException exception, String viewName) 
	{
		return new ModelAndView(viewName, WebModelConstants.ERROR_MESSAGE, exception.getMessage());
	}
}
