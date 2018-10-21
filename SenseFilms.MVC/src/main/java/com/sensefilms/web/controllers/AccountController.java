package com.sensefilms.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sensefilms.common.exceptions.UiNotAuthenticatedException;
import com.sensefilms.common.handlers.IAuthenticationContext;
import com.sensefilms.common.exceptions.UiException;
import com.sensefilms.common.utils.StringUtils;
import com.sensefilms.services.contracts.IUserSecurityService;
import com.sensefilms.services.contracts.IWebSupportService;
import com.sensefilms.web.controllers.base.BaseController;
import com.sensefilms.web.support.ViewsResources;

@Controller
public class AccountController extends BaseController
{
	private IUserSecurityService accountService;
	
	@Autowired
	public AccountController(IUserSecurityService accountService, IWebSupportService webSupportService, IAuthenticationContext authenticationContext) 
	{
		super(AccountController.class, authenticationContext);
		this.accountService = accountService;
	}
	
	@RequestMapping(value = "/AccountController/forgotPassword", method = RequestMethod.GET)	
	public String getForgotPasswordView() 
	{
		return ViewsResources.FORGOT_PASSWORD_VIEW;
	}
	
	@RequestMapping(value = "/AccountController/changePassword", method = RequestMethod.GET)	
	public String getChangePasswordView() 
	{
		return ViewsResources.NEW_PASSWORD_VIEW;
	}
	
	@RequestMapping(value = "/AccountController/sendNewPassword", method = RequestMethod.POST)	
	public ModelAndView sendNewPassword(@RequestParam("username") String username, Model model)
	{
		try 
		{
			accountService.updateNewPassord(username, StringUtils.EMPTY);
			return new ModelAndView(ViewsResources.HOME_VIEW);
		}
		catch(UiNotAuthenticatedException cbEx) 
		{
			return handleException(cbEx, ViewsResources.FORGOT_PASSWORD_VIEW);
		}
		catch(UiException chEx) 
		{
			return handleException(chEx);
		}
	}
								
	@RequestMapping(value = "/AccountController/updateNewPassword", method = RequestMethod.POST)	
	public ModelAndView setNewPassword(@RequestParam("currentPassword") String currentPassword,
			@RequestParam("newPassword") String newPassword, @RequestParam("confirmPassword") String confirmPassword, Model model)
	{
		if(!confirmPassword.equals(newPassword)) 
		{
			return showErrorMessage(ViewsResources.NEW_PASSWORD_VIEW, model);
		}
				
		try 
		{
			accountService.updateNewPassord(getLoggedUserName(), newPassword);			
			return new ModelAndView(ViewsResources.INDEX_VIEW);
		}
		catch(UiNotAuthenticatedException cbEx) 
		{
			return handleException(cbEx, ViewsResources.NEW_PASSWORD_VIEW);
		}
		catch(UiException chEx) 
		{
			return handleException(chEx);
		}
	}
}
