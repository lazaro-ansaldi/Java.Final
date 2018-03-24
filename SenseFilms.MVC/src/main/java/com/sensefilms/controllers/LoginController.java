package com.sensefilms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sensefilms.common.entities.User;
import com.sensefilms.services.contracts.ILoginService;

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
	public String authenticate(@ModelAttribute  User currentUser) 
	{
		loginService.tryAuthenticateUser(currentUser);
				
		return "username";
	}
	
}
