package com.sensefilms.repositories.base;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sensefilms.business.entities.base.IBaseEntity;
import com.sensefilms.common.utils.CastUtils;

@Repository
@Transactional
public abstract class BaseCRUDRepository<TEntity extends IBaseEntity> extends BaseRepository implements IBaseCRUDRepository<TEntity>
{
	private Class<TEntity> currentClazz;
	
	public BaseCRUDRepository(Class<TEntity> clazz) 
	{
		this.currentClazz = clazz;
	}
	
	@Override
	public void insert(TEntity entity) throws HibernateException
	{
		getSessionFactory().getCurrentSession().save(entity);			
	}

	@Override
	public TEntity getOneById(int id) throws HibernateException
	{
		Object clientObject = getSessionFactory().getCurrentSession().get(currentClazz, id);	
		return CastUtils.tryCastAs(currentClazz, clientObject);
	}

	@Override
	public void update(TEntity entity) throws HibernateException
	{
		getSessionFactory().getCurrentSession().update(entity);				
	}

	@Override
	public void deleteOneById(int id) throws HibernateException
	{
		getSessionFactory().getCurrentSession().delete(getSessionFactory().getCurrentSession().get(currentClazz, id));				
	}
	
	@Override
	public ArrayList<TEntity> getAll() throws HibernateException
	{
		List<TEntity> castedList = CastUtils.castList(currentClazz, getCriteria(currentClazz).list());
		return new ArrayList<TEntity>(castedList);		
	}
}
