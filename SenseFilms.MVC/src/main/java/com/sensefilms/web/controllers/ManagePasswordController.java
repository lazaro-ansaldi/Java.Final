package com.sensefilms.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sensefilms.common.exceptions.CustomHandledException;
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
			if(!accountService.generateNewPassword(username))
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
	
}
