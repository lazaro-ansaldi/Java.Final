package com.sensefilms.repositories.base;

import org.hibernate.HibernateException;

import com.sensefilms.business.entities.BaseEntity;

public interface IBaseCRUDRepository<T extends BaseEntity> 
{
	public void insert(T entity) throws HibernateException;
	
	public T getOneById(int id) throws HibernateException;
	
	public void update(T entity) throws HibernateException;
	
	public void deleteOneById(int id) throws HibernateException;
}
