package com.sensefilms.services.contracts;

import java.util.ArrayList;

import com.sensefilms.business.entities.Client;
import com.sensefilms.core.exceptions.UiException;

public interface IClientService
{
	void addNewClient(Client client) throws UiException;
	
	ArrayList<Client> getAllClients() throws UiException;
	
	void deleteClients(int[] idsToDelete) throws UiException;
}
