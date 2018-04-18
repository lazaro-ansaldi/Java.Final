package com.sensefilms.repositories.base;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseRepository
{

	@Autowired
	private SessionFactory sessionFactory;
	
	protected SessionFactory getSessionFactory() 
	{
		return this.sessionFactory;
	}
}