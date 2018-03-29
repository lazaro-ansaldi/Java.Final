package com.sensefilms.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sensefilms.common.exceptions.CustomHandledException;
import com.sensefilms.common.helpers.StringHelper;
import com.sensefilms.services.contracts.IAccountService;
import com.sensefilms.web.support.ViewsResources;
import com.sensefilms.web.support.WebConstants;

@Controller
public class ManagePasswordController extends BaseController
{
	private IAccountService accountService;
	
	@Autowired
	public ManagePasswordController(IAccountService accountService) 
	{
		super(ManagePasswordController.class);
		this.accountService = accountService;
	}
	
	@RequestMapping(value = "/ManagePasswordController/forgotPassword", method = RequestMethod.GET)	
	public String getForgotPasswordView() 
	{
		return ViewsResources.FORGOTPASSWORD_PAGE;
	}
	
	@RequestMapping(value = "/ManagePasswordController/sendNewPassword", method = RequestMethod.POST)	
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
								
	@RequestMapping(value = "/ManagePasswordController/updateNewPassword/{usernameParam}", method = RequestMethod.POST)	
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
