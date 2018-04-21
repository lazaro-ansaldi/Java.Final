package com.sensefilms.web.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sensefilms.web.controllers.base.BaseController;
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
	public ModelAndView home(Locale locale, Model model) 
	{
		getLogger().info("We're live! {}.", locale);
		
		return new ModelAndView(ViewsResources.HOME_VIEW);
	}
	
	@RequestMapping(value = "/HomeController/index", method = RequestMethod.GET)
	public ModelAndView getIndexView(Model model) 
	{		
		return new ModelAndView(ViewsResources.INDEX_VIEW);
	}
}
