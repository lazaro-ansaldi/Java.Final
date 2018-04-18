package com.sensefilms.services.implementation;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensefilms.business.entities.Client;
import com.sensefilms.common.exceptions.CustomHandledException;
import com.sensefilms.repositories.contracts.IClientRepository;
import com.sensefilms.services.base.BaseService;
import com.sensefilms.services.contracts.IClientsService;

@Service
public class ClientService extends BaseService implements IClientsService
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
			throw new CustomHandledException("An error ocurred when try to access the database.", hex);
		}
		catch(Exception ex)
		{
			throw new CustomHandledException("A totally unexpected error occurred. Please run as fast as you can!", ex);
		}
	}

}
