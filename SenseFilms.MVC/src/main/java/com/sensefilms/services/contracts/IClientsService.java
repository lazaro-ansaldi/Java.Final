package com.sensefilms.services.contracts;

import com.sensefilms.business.entities.Client;
import com.sensefilms.common.exceptions.CustomHandledException;

public interface IClientsService
{
	void addNewClient(Client client) throws CustomHandledException;
}
