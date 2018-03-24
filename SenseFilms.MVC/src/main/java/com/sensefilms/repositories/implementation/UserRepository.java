package com.sensefilms.repositories.implementation;

import java.sql.SQLException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sensefilms.common.entities.User;
import com.sensefilms.common.helpers.CastHelper;
import com.sensefilms.repositories.contracts.IUserRepository;

@Repository
@Transactional
public class UserRepository extends BaseRepository implements IUserRepository
{

	public void insert(User entity) throws SQLException 
	{
		getSessionFactory().getCurrentSession().save(entity);		
	}

	public User getOneById(int id) throws SQLException 
	{
		Object userObject = getSessionFactory().getCurrentSession().get(User.class, id);	
		return CastHelper.tryCastAs(User.class, userObject);
	}

	public void update(User entity) throws SQLException 
	{
		getSessionFactory().getCurrentSession().update(entity);		
	}

	public void deleteOneById(int id) throws SQLException 
	{
		
	}

	public User getOneByUsername(String username) throws SQLException 
	{
		Query query = getSessionFactory().getCurrentSession().createQuery("from User where username = :username");
		query.setParameter("username", username);
		return CastHelper.tryCastAs(User.class, query.uniqueResult());
	}

}
