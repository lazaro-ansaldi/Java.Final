package com.sensefilms.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sensefilms.business.entities.Client;
import com.sensefilms.common.exceptions.CustomHandledException;
import com.sensefilms.services.contracts.IClientService;
import com.sensefilms.web.controllers.base.BaseAjaxController;
import com.sensefilms.web.support.ViewsResources;
import com.sensefilms.web.support.WebModelConstants;

@Controller
public class ManageClientsController extends BaseAjaxController
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
	
	@ResponseBody
	@RequestMapping(value = "/ManageClientsController/deleteClients", method = RequestMethod.DELETE)	
	public ResponseEntity<Object> deleteClients(@RequestBody int[] clientsToDelete)
	{
		try 
		{
			clientService.deleteClients(clientsToDelete);
			return statusOk();
		}
		catch(CustomHandledException chEx) 
		{
			return handleException(chEx.getMessage());
		}	
	}
}
