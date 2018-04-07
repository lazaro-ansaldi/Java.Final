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
import com.sensefilms.web.support.WebModelConstants;

@Controller
public class ManageUsersController extends BaseController
{
	private IAccountService accountService;
	
	@Autowired
	public ManageUsersController(IAccountService accountService) 
	{
		super(AccountController.class);
		this.accountService = accountService;
	}

	@RequestMapping(value = "/ManageUsersController/addUser", method = RequestMethod.POST)
	public String createNewUser(@ModelAttribute  User newUser, Model model) 
	{
		try 
		{			
			this.accountService.addNewUser(newUser);
			return ViewsResources.INDEX_VIEW;
		}
		catch(CustomHandledException chEx) 
		{
			model.addAttribute(WebModelConstants.ERROR_MESSAGE, chEx.getMessage());
			return ViewsResources.ERROR_VIEW;
		}		
	}
	
	@RequestMapping(value = "/ManageUsersController/newUser", method = RequestMethod.GET)	
	public String getNewUserView() 
	{
		return ViewsResources.NEW_USER_VIEW;
	}
}
