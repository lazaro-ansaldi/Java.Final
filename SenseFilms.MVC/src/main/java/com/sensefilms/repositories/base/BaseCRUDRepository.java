package com.sensefilms.repositories.base;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sensefilms.business.entities.base.BaseEntity;
import com.sensefilms.common.utils.CastUtils;

@Repository
@Transactional
public abstract class BaseCRUDRepository<T extends BaseEntity> extends BaseRepository implements IBaseCRUDRepository<T>
{
	private Class<T> currentClazz;
	
	public BaseCRUDRepository(Class<T> clazz) 
	{
		this.currentClazz = clazz;
	}
	
	@Override
	public void insert(T entity) throws HibernateException
	{
		getSessionFactory().getCurrentSession().save(entity);			
	}

	@Override
	public T getOneById(int id) throws HibernateException
	{
		Object clientObject = getSessionFactory().getCurrentSession().get(currentClazz, id);	
		return CastUtils.tryCastAs(currentClazz, clientObject);
	}

	@Override
	public void update(T entity) throws HibernateException
	{
		getSessionFactory().getCurrentSession().update(entity);				
	}

	@Override
	public void deleteOneById(int id) throws HibernateException
	{
		getSessionFactory().getCurrentSession().delete(getSessionFactory().getCurrentSession().get(currentClazz, id));				
	}
	
	@Override
	public ArrayList<T> getAll() throws HibernateException
	{
		List<T> castedList = CastUtils.castList(currentClazz, getCriteria(currentClazz).list());
		return new ArrayList<T>(castedList);		
	}
}
