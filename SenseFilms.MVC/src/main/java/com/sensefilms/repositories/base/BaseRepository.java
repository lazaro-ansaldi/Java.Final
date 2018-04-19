package com.sensefilms.repositories.base;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sensefilms.business.entities.base.BaseEntity;

public abstract class BaseRepository
{
	@Autowired
	private SessionFactory sessionFactory;
	
	protected SessionFactory getSessionFactory() 
	{
		return this.sessionFactory;
	}
	
	protected Criteria getCriteria(Class<? extends BaseEntity> clazz) 
	{
		return this.sessionFactory.getCurrentSession().createCriteria(clazz);
	}
}
