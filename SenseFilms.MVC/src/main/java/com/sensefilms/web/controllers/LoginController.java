package com.sensefilms.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sensefilms.business.entities.User;
import com.sensefilms.common.exceptions.CustomHandledException;
import com.sensefilms.services.contracts.IAccountService;
import com.sensefilms.web.support.ViewsResources;
import com.sensefilms.web.support.WebConstants;

@Controller
public class LoginController extends BaseController
{
	private IAccountService accountService;
	
	@Autowired
	public LoginController(IAccountService accountService) 
	{
		super(LoginController.class);
		this.accountService = accountService;
	}
	
	@RequestMapping(value = "/LoginController/login", method = RequestMethod.POST)
	public String authenticate(@ModelAttribute  User currentUser, Model model) 
	{
		try 
		{
			if(!accountService.tryAuthenticateUser(currentUser)) 
			{
				model.addAttribute(WebConstants.ERROR_MESSAGE, "Incorrect credentials, please try again.");
				return ViewsResources.HOME_PAGE;
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
