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
import com.sensefilms.common.exceptions.CustomHandledException;
import com.sensefilms.common.helpers.StringHelper;
import com.sensefilms.services.contracts.IAccountService;
import com.sensefilms.services.implementation.AccountService;
import com.sensefilms.web.support.ViewsResources;
import com.sensefilms.web.support.WebConstants;

@Controller
public class AccountController extends BaseController
{
	private IAccountService accountService;
	
	@Autowired
	public AccountController(IAccountService accountService) 
	{
		super(AccountController.class);
		this.accountService = accountService;
	}
	
	@RequestMapping(value = "/AccountController/authenticate", method = RequestMethod.POST)
	public String authenticate(@ModelAttribute  User currentUser, Model model) 
	{
		try 
		{
			if(!accountService.tryAuthenticateUser(currentUser)) 
			{
				model.addAttribute(WebConstants.ERROR_MESSAGE, "Incorrect credentials, please try again.");
				return ViewsResources.HOME_PAGE;
			}
			
			User authenticadeUser = AccountService.getAuthenticatedUserByUsername(currentUser.getUsername());
			
			model.addAttribute(WebConstants.USERNAME_PARAM, authenticadeUser.getUsername());
			model.addAttribute(WebConstants.USER_COMPLETE_NAME, authenticadeUser.getCompleteName());
					
			return (!authenticadeUser.isNewPassword() ? ViewsResources.INDEX_PAGE : ViewsResources.NEWPASSWORD_PAGE);
		}
		catch(CustomHandledException chEx) 
		{
			model.addAttribute(WebConstants.ERROR_MESSAGE, chEx.getMessage());
			return ViewsResources.ERROR_PAGE;
		}		
	}
	
	@RequestMapping(value = "/AccountController/forgotPassword", method = RequestMethod.GET)	
	public String getForgotPasswordView() 
	{
		return ViewsResources.FORGOTPASSWORD_PAGE;
	}
	
	@RequestMapping(value = "/AccountController/sendNewPassword", method = RequestMethod.POST)	
	public String sendNewPassword(@RequestParam("username") String username, Model model)
	{
		try 
		{
			if(!accountService.updateNewPassord(username, StringHelper.EMPTY))
			{
				model.addAttribute(WebConstants.ERROR_MESSAGE, "The username doesn't exists.");
				return ViewsResources.FORGOTPASSWORD_PAGE;
			}
			
			return ViewsResources.HOME_PAGE;
		}
		catch(CustomHandledException chEx) 
		{
			model.addAttribute(WebConstants.ERROR_MESSAGE, chEx.getMessage());
			return ViewsResources.ERROR_PAGE;
		}
	}
								
	@RequestMapping(value = "/AccountController/updateNewPassword/{usernameParam}", method = RequestMethod.POST)	
	public String setNewPassword(@RequestParam("currentPassword") String currentPassword, @PathVariable("usernameParam") String username,
			@RequestParam("newPassword") String newPassword, @RequestParam("confirmPassword") String confirmPassword, Model model)
	{
		if(!confirmPassword.equals(newPassword)) 
		{
			model.addAttribute(WebConstants.ERROR_MESSAGE, "The confirmation password does not match with the new one.");
			return ViewsResources.NEWPASSWORD_PAGE;
		}
				
		try 
		{
			if(!accountService.updateNewPassord(username, newPassword))
			{
				model.addAttribute(WebConstants.ERROR_MESSAGE, "The username doesn't exists.");
				return ViewsResources.NEWPASSWORD_PAGE;
			}
			
			return ViewsResources.INDEX_PAGE;
		}
		catch(CustomHandledException chEx) 
		{
			model.addAttribute(WebConstants.ERROR_MESSAGE, chEx.getMessage());
			return ViewsResources.ERROR_PAGE;
		}
	}
	
}
