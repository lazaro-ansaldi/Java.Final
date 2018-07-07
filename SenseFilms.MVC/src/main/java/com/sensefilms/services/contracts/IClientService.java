package com.sensefilms.services.contracts;

import java.util.ArrayList;

import com.sensefilms.business.entities.Client;
import com.sensefilms.common.exceptions.CustomHandledException;

public interface IClientService
{
	void addNewClient(Client client) throws CustomHandledException;
	
	ArrayList<Client> getAllClients() throws CustomHandledException;
	
	void deleteClients(int[] idsToDelete) throws CustomHandledException;
}
