package com.sensefilms.repositories.implementation;

import java.sql.SQLException;

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

	@Override
	public void insert(Client client) throws SQLException
	{
		super.insert(client);		
	}

	@Override
	public Client getOneById(int id) throws SQLException
	{
		return super.getOneById(id);
	}

	@Override
	public void update(Client client) throws SQLException
	{
		super.update(client);			
	}

	@Override
	public void deleteOneById(int id) throws SQLException
	{
		super.deleteOneById(id);			
	}

}
