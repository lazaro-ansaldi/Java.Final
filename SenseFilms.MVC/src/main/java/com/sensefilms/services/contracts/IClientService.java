package com.sensefilms.services.contracts;

import java.util.List;

import com.sensefilms.core.dtos.ClientDto;
import com.sensefilms.core.exceptions.UiException;

public interface IClientService
{
	void addNewClient(ClientDto clientDto) throws UiException;
	
	List<ClientDto> getAllClients() throws UiException;
	
	void deleteClients(int[] idsToDelete) throws UiException;
}
