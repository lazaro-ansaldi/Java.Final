package com.sensefilms.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sensefilms.business.entities.User;
import com.sensefilms.common.exceptions.CustomHandledException;
import com.sensefilms.services.contracts.ILoginService;
import com.sensefilms.web.support.ViewsResources;
import com.sensefilms.web.support.WebConstants;

@Controller
public class ManagePasswordController extends BaseController
{
	private ILoginService loginService;
	
	@Autowired
	public ManagePasswordController(ILoginService loginService) 
	{
		super(ManagePasswordController.class);
		this.loginService = loginService;
	}
	
	@RequestMapping(value = "/ManagePasswordController/forgotPassword", method = RequestMethod.GET)	
	public String getForgotPasswordView() 
	{
		return ViewsResources.FORGOTPASSWORD_PAGE;
	}
	
//	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
//	public String authenticate(@ModelAttribute  User currentUser, Model model) 
//	{
//		
//	}
	
	
}
