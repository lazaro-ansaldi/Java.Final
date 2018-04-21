package com.sensefilms.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sensefilms.business.entities.Client;
import com.sensefilms.common.exceptions.CustomHandledException;
import com.sensefilms.services.contracts.IClientService;
import com.sensefilms.web.controllers.base.BaseController;
import com.sensefilms.web.support.ViewsResources;
import com.sensefilms.web.support.WebModelConstants;

@Controller
public class ManageClientsController extends BaseController
{
	private IClientService clientService;
	
	@Autowired
	public ManageClientsController(IClientService clientService) 
	{
		super(ManageClientsController.class);
		this.clientService = clientService;
	}
	
	@RequestMapping(value = "/ManageClientsController/manageClients", method = RequestMethod.GET)	
	public ModelAndView getManageClientsView() 
	{
		try 
		{
			return new ModelAndView(ViewsResources.CLIENT_LIST_VIEW, WebModelConstants.CLIENT_LIST, clientService.getAllClients());
		}
		catch(CustomHandledException chEx) 
		{
			return handleException(chEx);
		}	
	}
	
	@RequestMapping(value = "/ManageClientsController/createClient", method = RequestMethod.POST)	
	public ModelAndView createNewClient(@ModelAttribute  Client newClient, Model model) 
	{
		try 
		{
			clientService.addNewClient(newClient);
			return new ModelAndView(ViewsResources.CLIENT_LIST_VIEW);
		}
		catch(CustomHandledException chEx) 
		{
			return handleException(chEx);
		}	
	}
}
