package com.sensefilms.repositories.base;

import org.hibernate.HibernateException;

import com.sensefilms.business.entities.BaseEntity;
import com.sensefilms.common.helpers.CastHelper;

public class BaseCRUDRepository<T extends BaseEntity> extends BaseRepository implements IBaseCRUDRepository<T>
{
	private Class<T> currentClazz;
	
	public BaseCRUDRepository(Class<T> clazz) 
	{
		this.currentClazz = clazz;
	}
	
	public void insert(T entity) throws HibernateException
	{
		getSessionFactory().getCurrentSession().save(entity);			
	}

	public T getOneById(int id) throws HibernateException
	{
		Object clientObject = getSessionFactory().getCurrentSession().get(currentClazz, id);	
		return CastHelper.tryCastAs(currentClazz, clientObject);
	}

	public void update(T entity) throws HibernateException
	{
		getSessionFactory().getCurrentSession().update(entity);				
	}

	public void deleteOneById(int id) throws HibernateException
	{
		getSessionFactory().getCurrentSession().delete(getSessionFactory().getCurrentSession().get(currentClazz, id));				
	}
}
