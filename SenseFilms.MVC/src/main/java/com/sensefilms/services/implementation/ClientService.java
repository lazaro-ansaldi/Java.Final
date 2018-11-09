package com.sensefilms.services.implementation;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensefilms.business.entities.Client;
import com.sensefilms.core.exceptions.ErrorMessages;
import com.sensefilms.core.exceptions.UiException;
import com.sensefilms.repositories.contracts.IClientRepository;
import com.sensefilms.services.base.BaseService;
import com.sensefilms.services.contracts.IClientService;

@Service
public final class ClientService extends BaseService implements IClientService
{
	private IClientRepository clientRepository;
	
	@Autowired
	public ClientService(IClientRepository clientRepository) 
	{
		super(ClientService.class);
		this.clientRepository = clientRepository;
	}
	
	@Override
	public void addNewClient(Client client) throws UiException
	{
		try 
		{
			this.clientRepository.insert(client);
			getLogger().debug(String.format("Client %s has been created.", client.getCompleteName()));
		}
		catch(HibernateException hex)
		{
			throw new UiException(ErrorMessages.HIBERNATE_ERROR_MESSAGE, hex);
		}
		catch(Exception ex)
		{
			throw new UiException(ErrorMessages.GENERIC_ERROR_MESSAGE, ex);
		}
	}

	@Override
	public ArrayList<Client> getAllClients() throws UiException
	{
		try 
		{
			return this.clientRepository.getAll();
		}
		catch(HibernateException hex)
		{
			throw new UiException(ErrorMessages.HIBERNATE_ERROR_MESSAGE, hex);
		}
		catch(Exception ex)
		{
			throw new UiException(ErrorMessages.GENERIC_ERROR_MESSAGE, ex);
		}
	}

	@Override
	public void deleteClients(int[] idsToDelete) throws UiException
	{
		try 
		{
			if(idsToDelete.length > 1)
			{
				this.clientRepository.deleteRange(idsToDelete);
			}
			else
			{
				this.clientRepository.deleteOneById(idsToDelete[0]);
			}
		}
		catch(HibernateException hex)
		{
			throw new UiException(ErrorMessages.HIBERNATE_ERROR_MESSAGE, hex);
		}
		catch(Exception ex)
		{
			throw new UiException(ErrorMessages.GENERIC_ERROR_MESSAGE, ex);
		}		
	}
}
