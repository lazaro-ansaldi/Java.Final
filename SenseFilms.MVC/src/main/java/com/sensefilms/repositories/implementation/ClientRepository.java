package com.sensefilms.repositories.implementation;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sensefilms.repositories.base.BaseCRUDRepository;
import com.sensefilms.repositories.contracts.IClientRepository;
import com.sensefilms.repositories.entities.Client;

@Repository
@Transactional
public class ClientRepository extends BaseCRUDRepository<Client> implements IClientRepository
{
	public ClientRepository()
	{
		super(Client.class);
	}
	
	public void deleteRange(int[] ids) 
	{
		Query query = getSessionFactory().getCurrentSession().createQuery("DELETE Client WHERE id IN (:ids)");
		query.setParameter("ids", ids);
		query.executeUpdate();
	}
}
