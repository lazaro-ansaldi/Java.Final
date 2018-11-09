package com.sensefilms.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sensefilms.core.dtos.ClientDto;
import com.sensefilms.core.exceptions.UiException;
import com.sensefilms.core.utilities.IAuthenticationContext;
import com.sensefilms.services.contracts.IClientService;
import com.sensefilms.web.controllers.base.BaseAjaxController;
import com.sensefilms.web.support.PaginationSupport;
import com.sensefilms.web.support.ViewsResources;
import com.sensefilms.web.support.WebModelConstants;

@Controller
public class ManageClientsController extends BaseAjaxController
{
	private IClientService clientService;
	
	@Autowired
	public ManageClientsController(IClientService clientService, IAuthenticationContext authenticationContext) 
	{
		super(ManageClientsController.class, authenticationContext);
		this.clientService = clientService;
	}
	
	@RequestMapping(value = "/ManageClientsController/manageClients", method = RequestMethod.GET)	
	public ModelAndView getManageClientsView() 
	{
		try 
		{
			return new ModelAndView(ViewsResources.CLIENT_LIST_VIEW, WebModelConstants.CLIENT_LIST, clientService.getAllClients());
		}
		catch(UiException chEx) 
		{
			return handleException(chEx);
		}	
	}
	
	@RequestMapping(value = "/ManageClientsController/createClient", method = RequestMethod.POST)	
	public ModelAndView createNewClient(@ModelAttribute ClientDto newClientDto, Model model) 
	{
		try 
		{
			clientService.addNewClient(newClientDto);
			return new ModelAndView(ViewsResources.CLIENT_LIST_VIEW);
		}
		catch(UiException chEx) 
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
		catch(UiException chEx) 
		{
			return handleException(chEx.getMessage());
		}	
	}
	
	@ResponseBody
	@RequestMapping(value = "/ManageClientsController/pagedClients", method = RequestMethod.GET)	
	public ResponseEntity<Object> getPagedClients(@RequestParam int pageSize, @RequestParam int currentPage)
	{
		try 
		{
			PaginationSupport<ClientDto> paginationSupport = new PaginationSupport<ClientDto>(this.clientService.getAllClients(), pageSize, currentPage, "/ManageClientsController/pagedClients");
			return statusOk(paginationSupport);
		}
		catch(UiException chEx) 
		{
			return handleException(chEx.getMessage());
		}	
	}
}
