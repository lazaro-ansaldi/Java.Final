package com.sensefilms.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sensefilms.business.entities.User;
import com.sensefilms.common.exceptions.CustomBusinessException;
import com.sensefilms.common.exceptions.CustomHandledException;
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
	private IWebSupportService webSupportService;
	
	@Autowired
	public AccountController(IAccountService accountService, IWebSupportService webSupportService) 
	{
		super(AccountController.class);
		this.accountService = accountService;
		this.webSupportService = webSupportService;
	}
	
	@RequestMapping(value = "/AccountController/authenticate", method = RequestMethod.POST)
	public String authenticate(@ModelAttribute  User currentUser, Model model) 
	{
		try 
		{
			accountService.tryAuthenticateUser(currentUser);
			
			User authenticadeUser = AccountService.getAuthenticatedUserByUsername(currentUser.getUsername());
			
			model.addAttribute(WebModelConstants.USERNAME_PARAM, authenticadeUser.getUsername());
			model.addAttribute(WebModelConstants.USER_COMPLETE_NAME, authenticadeUser.getCompleteName());
			model.addAttribute(WebModelConstants.MENU_ITEMS, webSupportService.getAllWebMenuItems());
					
			return (!authenticadeUser.isNewPassword() ? ViewsResources.INDEX_VIEW : ViewsResources.NEW_PASSWORD_VIEW);
		}
		catch(CustomBusinessException cbEx) 
		{
			model.addAttribute(WebModelConstants.ERROR_MESSAGE, cbEx.getMessage());
			return ViewsResources.HOME_VIEW;
		}
		catch(CustomHandledException chEx) 
		{
			model.addAttribute(WebModelConstants.ERROR_MESSAGE, chEx.getMessage());
			return ViewsResources.ERROR_VIEW;
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
	public String sendNewPassword(@RequestParam("username") String username, Model model)
	{
		try 
		{
			accountService.updateNewPassord(username, StringUtils.EMPTY);
			return ViewsResources.HOME_VIEW;
		}
		catch(CustomBusinessException cbEx) 
		{
			model.addAttribute(WebModelConstants.ERROR_MESSAGE, cbEx.getMessage());
			return ViewsResources.FORGOT_PASSWORD_VIEW;
		}
		catch(CustomHandledException chEx) 
		{
			model.addAttribute(WebModelConstants.ERROR_MESSAGE, chEx.getMessage());
			return ViewsResources.ERROR_VIEW;
		}
	}
								
	@RequestMapping(value = "/AccountController/updateNewPassword/{usernameParam}", method = RequestMethod.POST)	
	public String setNewPassword(@RequestParam("currentPassword") String currentPassword, @PathVariable("usernameParam") String username,
			@RequestParam("newPassword") String newPassword, @RequestParam("confirmPassword") String confirmPassword, Model model)
	{
		if(!confirmPassword.equals(newPassword)) 
		{
			model.addAttribute(WebModelConstants.ERROR_MESSAGE, "The confirmation password does not match with the new one.");
			return ViewsResources.NEW_PASSWORD_VIEW;
		}
				
		try 
		{
			accountService.updateNewPassord(username, newPassword);			
			return ViewsResources.INDEX_VIEW;
		}
		catch(CustomBusinessException cbEx) 
		{
			model.addAttribute(WebModelConstants.ERROR_MESSAGE, cbEx.getMessage());
			return ViewsResources.NEW_PASSWORD_VIEW;
		}
		catch(CustomHandledException chEx) 
		{
			model.addAttribute(WebModelConstants.ERROR_MESSAGE, chEx.getMessage());
			return ViewsResources.ERROR_VIEW;
		}
	}
}
