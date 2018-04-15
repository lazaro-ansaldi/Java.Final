package com.sensefilms.repositories.implementation;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sensefilms.business.entities.Client;
import com.sensefilms.common.helpers.CastHelper;
import com.sensefilms.repositories.contracts.IClientRepository;

@Repository
@Transactional
public class ClientRepository extends BaseRepository implements IClientRepository
{

	@Override
	public void insert(Client entity) throws SQLException
	{
		getSessionFactory().getCurrentSession().save(entity);			
	}

	@Override
	public Client getOneById(int id) throws SQLException
	{
		Object clientObject = getSessionFactory().getCurrentSession().get(Client.class, id);	
		return CastHelper.tryCastAs(Client.class, clientObject);
	}

	@Override
	public void update(Client entity) throws SQLException
	{
		getSessionFactory().getCurrentSession().update(entity);				
	}

	@Override
	public void deleteOneById(int id) throws SQLException
	{
		getSessionFactory().getCurrentSession().delete(getSessionFactory().getCurrentSession().get(Client.class, id));				
	}

}
