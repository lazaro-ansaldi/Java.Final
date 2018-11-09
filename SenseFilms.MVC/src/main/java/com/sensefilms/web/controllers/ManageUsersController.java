package com.sensefilms.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sensefilms.core.exceptions.UiException;
import com.sensefilms.core.utilities.IAuthenticationContext;
import com.sensefilms.repositories.entities.User;
import com.sensefilms.services.contracts.IUserAuthenticationService;
import com.sensefilms.web.controllers.base.BaseController;
import com.sensefilms.web.support.ViewsResources;

@Controller
public class ManageUsersController extends BaseController
{
	private IUserAuthenticationService accountService;
	
	@Autowired
	public ManageUsersController(IUserAuthenticationService accountService, IAuthenticationContext authenticationContext) 
	{
		super(AccountController.class, authenticationContext);
		this.accountService = accountService;
	}

	@RequestMapping(value = "/ManageUsersController/addUser", method = RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute  User newUser, Model model) 
	{
		try 
		{			
			this.accountService.addNewUser(newUser);
			return new ModelAndView(ViewsResources.INDEX_VIEW);
		}
		catch(UiException chEx) 
		{
			return handleException(chEx);
		}		
	}
	
	@RequestMapping(value = "/ManageUsersController/newUser", method = RequestMethod.GET)	
	public ModelAndView getNewUserView() 
	{
		return new ModelAndView(ViewsResources.NEW_USER_VIEW);
	}
}
