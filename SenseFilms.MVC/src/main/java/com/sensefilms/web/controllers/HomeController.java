package com.sensefilms.web.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sensefilms.web.support.ViewsResources;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends BaseController
{	
	public HomeController() 
	{
		super(HomeController.class);	
	}
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) 
	{
		getLogger().info("Welcome home! The client locale is {}.", locale);
		
		return ViewsResources.HOME_PAGE;
	}
	
}
