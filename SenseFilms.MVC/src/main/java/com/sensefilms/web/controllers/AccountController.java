package com.sensefilms.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sensefilms.business.entities.User;
import com.sensefilms.common.exceptions.UiNotAuthenticatedException;
import com.sensefilms.common.exceptions.UiException;
import com.sensefilms.common.utils.StringUtils;
import com.sensefilms.services.contracts.IAccountService;
import com.sensefilms.services.contracts.IWebSupportService;
import com.sensefilms.services.implementation.AccountService;
import com.sensefilms.web.controllers.base.BaseController;
import com.sensefilms.web.support.ViewsResources;
import com.sensefilms.web.support.WebModelConstants;

@Controller
public class AccountController extends BaseController
{
	private IAccountService accountService;
	
	@Autowired
	public AccountController(IAccountService accountService, IWebSupportService webSupportService) 
	{
		super(AccountController.class);
		this.accountService = accountService;
	}
	
	@RequestMapping(value = "/AccountController/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute  User currentUser, Model model) 
	{
		try 
		{
			accountService.tryAuthenticateUser(currentUser);
			
			User authenticadeUser = AccountService.getAuthenticatedUserByUsername(currentUser.getUsername());
			// Init model attributes
			model.addAttribute(WebModelConstants.USERNAME_PARAM, authenticadeUser.getUsername());
			model.addAttribute(WebModelConstants.USER_COMPLETE_NAME, authenticadeUser.getCompleteName());
			
			String viewToReturn = (!authenticadeUser.isNewPassword() ? ViewsResources.INDEX_VIEW : ViewsResources.NEW_PASSWORD_VIEW);
			
			return new ModelAndView(viewToReturn, StringUtils.EMPTY, model);
		}
		catch(UiNotAuthenticatedException cbEx) 
		{
			return handleException(cbEx, ViewsResources.HOME_VIEW);
		}
		catch(UiException chEx) 
		{
			return handleException(chEx);
		}		
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
								
	@RequestMapping(value = "/AccountController/updateNewPassword/{usernameParam}", method = RequestMethod.POST)	
	public ModelAndView setNewPassword(@RequestParam("currentPassword") String currentPassword, @PathVariable("usernameParam") String username,
			@RequestParam("newPassword") String newPassword, @RequestParam("confirmPassword") String confirmPassword, Model model)
	{
		if(!confirmPassword.equals(newPassword)) 
		{
			return new ModelAndView(ViewsResources.NEW_PASSWORD_VIEW, WebModelConstants.ERROR_MESSAGE, model);
		}
				
		try 
		{
			accountService.updateNewPassord(username, newPassword);			
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
