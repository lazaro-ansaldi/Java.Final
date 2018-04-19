package com.sensefilms.services.implementation;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensefilms.business.entities.Client;
import com.sensefilms.common.exceptions.CustomHandledException;
import com.sensefilms.common.utils.CommonConstants;
import com.sensefilms.repositories.contracts.IClientRepository;
import com.sensefilms.services.base.BaseService;
import com.sensefilms.services.contracts.IClientService;

@Service
public class ClientService extends BaseService implements IClientService
{
	private IClientRepository clientRepository;
	
	@Autowired
	public ClientService(IClientRepository clientRepository) 
	{
		super(ClientService.class);
		this.clientRepository = clientRepository;
	}
	
	@Override
	public void addNewClient(Client client) throws CustomHandledException
	{
		try 
		{
			this.clientRepository.insert(client);
			getLogger().debug(String.format("The client %s has been created.", client.getCompleteName()));
		}
		catch(HibernateException hex)
		{
			throw new CustomHandledException(CommonConstants.HIBERNATE_ERROR_MESSAGE, hex);
		}
		catch(Exception ex)
		{
			throw new CustomHandledException(CommonConstants.GENERIC_ERROR_MESSAGE, ex);
		}
	}

	@Override
	public ArrayList<Client> getAllClients() throws CustomHandledException
	{
		try 
		{
			return this.clientRepository.getAll();
		}
		catch(HibernateException hex)
		{
			throw new CustomHandledException(CommonConstants.HIBERNATE_ERROR_MESSAGE, hex);
		}
		catch(Exception ex)
		{
			throw new CustomHandledException(CommonConstants.GENERIC_ERROR_MESSAGE, ex);
		}
	}

}
