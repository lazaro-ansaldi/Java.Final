package com.sensefilms.repositories.implementation;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseRepository
{

	@Autowired
	private SessionFactory sessionFactory;
		
	public BaseRepository() 
	{
		
	}
	
	protected SessionFactory getSessionFactory() 
	{
		return this.sessionFactory;
	}
}
