package com.sensefilms.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sensefilms.business.entities.User;
import com.sensefilms.common.exceptions.UiException;
import com.sensefilms.services.contracts.IUserSecurityService;
import com.sensefilms.web.controllers.base.BaseController;
import com.sensefilms.web.support.ViewsResources;

@Controller
public class ManageUsersController extends BaseController
{
	private IUserSecurityService accountService;
	
	@Autowired
	public ManageUsersController(IUserSecurityService accountService) 
	{
		super(AccountController.class);
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
