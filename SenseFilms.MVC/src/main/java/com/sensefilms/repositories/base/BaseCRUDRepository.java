package com.sensefilms.repositories.base;

import java.sql.SQLException;

import com.sensefilms.business.entities.BaseEntity;
import com.sensefilms.common.helpers.CastHelper;

public class BaseCRUDRepository<T extends BaseEntity> extends BaseRepository
{
	private Class<T> currentClazz;
	
	public BaseCRUDRepository(Class<T> clazz) 
	{
		this.currentClazz = clazz;
	}
	
	public void insert(T entity) throws SQLException
	{
		getSessionFactory().getCurrentSession().save(entity);			
	}

	public T getOneById(int id) throws SQLException
	{
		Object clientObject = getSessionFactory().getCurrentSession().get(currentClazz, id);	
		return CastHelper.tryCastAs(currentClazz, clientObject);
	}

	public void update(T entity) throws SQLException
	{
		getSessionFactory().getCurrentSession().update(entity);				
	}

	public void deleteOneById(int id) throws SQLException
	{
		getSessionFactory().getCurrentSession().delete(getSessionFactory().getCurrentSession().get(currentClazz, id));				
	}
}
