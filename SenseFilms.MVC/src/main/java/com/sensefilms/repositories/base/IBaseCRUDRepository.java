package com.sensefilms.repositories.base;

import java.util.ArrayList;

import org.hibernate.HibernateException;

import com.sensefilms.repositories.entities.base.IBaseEntity;

public interface IBaseCRUDRepository<TEntity extends IBaseEntity> 
{
	public void insert(TEntity entity) throws HibernateException;
	
	public TEntity getOneById(int id) throws HibernateException;
	
	public void update(TEntity entity) throws HibernateException;
	
	public void deleteOneById(int id) throws HibernateException;
	
	public ArrayList<TEntity> getAll() throws HibernateException;
}
