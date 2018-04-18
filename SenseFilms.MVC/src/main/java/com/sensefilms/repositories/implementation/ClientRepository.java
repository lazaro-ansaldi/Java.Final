package com.sensefilms.repositories.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sensefilms.business.entities.Client;
import com.sensefilms.repositories.base.BaseCRUDRepository;
import com.sensefilms.repositories.contracts.IClientRepository;

@Repository
@Transactional
public class ClientRepository extends BaseCRUDRepository<Client> implements IClientRepository
{
	public ClientRepository()
	{
		super(Client.class);
	}
}
