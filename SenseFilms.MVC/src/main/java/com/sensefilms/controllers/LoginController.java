package com.sensefilms.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController 
{
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authenticate(@RequestParam Map<String, String> reqParams) 
	{
		String username = reqParams.getOrDefault("username", "");

		return username;
	}
}
