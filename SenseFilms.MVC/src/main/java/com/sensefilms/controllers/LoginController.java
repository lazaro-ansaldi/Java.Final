package com.sensefilms.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String authenticate(@RequestParam Map<String, String> reqParams) 
	{
		String username = reqParams.getOrDefault("username", "");
		String password = reqParams.getOrDefault("password", "");

		return username;
	}
}
