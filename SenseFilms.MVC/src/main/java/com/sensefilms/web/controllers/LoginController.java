package com.sensefilms.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sensefilms.business.entities.User;
import com.sensefilms.services.contracts.ILoginService;
import com.sensefilms.web.support.ViewsResources;
import com.sensefilms.web.support.WebConstants;

@Controller
public class LoginController extends BaseController
{
	private ILoginService loginService;
	
	@Autowired
	public LoginController(ILoginService loginService) 
	{
		super(LoginController.class);
		this.loginService=loginService;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authenticate(@ModelAttribute  User currentUser, Model model) 
	{
		if(!loginService.tryAuthenticateUser(currentUser)) 
		{
			model.addAttribute(WebConstants.ERROR_MESSAGE, "Incorrect credentials, please try again.");
			return ViewsResources.HOME_PAGE;
		}
				
		return "username";
	}
	
}
