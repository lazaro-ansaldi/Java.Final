package com.sensefilms.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
			return new ModelAndView(ViewsResources.CLIENT_LIST_VIEW, "clientsList", clientService.getAllClients());
		}
		catch(CustomHandledException chEx) 
		{
			return new ModelAndView(ViewsResources.ERROR_VIEW, WebModelConstants.ERROR_MESSAGE, chEx.getMessage());
		}	
	}
}
