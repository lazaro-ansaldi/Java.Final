package com.sensefilms.web.controllers.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.sensefilms.common.exceptions.UiException;
import com.sensefilms.common.handlers.IAuthenticationContext;
import com.sensefilms.web.support.ViewsResources;
import com.sensefilms.web.support.WebModelConstants;

@Controller
public abstract class BaseController 
{

	private Logger logger;
	private IAuthenticationContext _authenticationContext;
	
	public BaseController(Class<? extends BaseController> clazz, IAuthenticationContext authenticationContext) 
	{
		this.logger = LoggerFactory.getLogger(clazz);
		_authenticationContext = authenticationContext;
	}
	
	protected Logger getLogger() 
	{
		return this.logger;
	}
	
	protected ModelAndView handleException(UiException exception) 
	{
		return new ModelAndView(ViewsResources.ERROR_VIEW, WebModelConstants.ERROR_MESSAGE, exception.getMessage());
	}
	
	protected ModelAndView handleException(UiException exception, String viewName) 
	{
		return new ModelAndView(viewName, WebModelConstants.ERROR_MESSAGE, exception.getMessage());
	}
	
	protected String getLoggedUserName() throws UiException 
	{
		return _authenticationContext.getLoggedUsername();
	}
	
	protected boolean isUserAuthenticated() 
	{
		return _authenticationContext.isLoggedIn();
	}
}
