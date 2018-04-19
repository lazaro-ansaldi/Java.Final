package com.sensefilms.repositories.base;

import java.util.ArrayList;

import org.hibernate.HibernateException;

import com.sensefilms.business.entities.base.BaseEntity;

public interface IBaseCRUDRepository<T extends BaseEntity> 
{
	public void insert(T entity) throws HibernateException;
	
	public T getOneById(int id) throws HibernateException;
	
	public void update(T entity) throws HibernateException;
	
	public void deleteOneById(int id) throws HibernateException;
	
	public ArrayList<T> getAll() throws HibernateException;
}
