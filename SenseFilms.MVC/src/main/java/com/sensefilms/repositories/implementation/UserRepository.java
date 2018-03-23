package com.sensefilms.repositories.implementation;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.sensefilms.common.entities.User;
import com.sensefilms.common.helpers.CastHelper;
import com.sensefilms.repositories.contracts.IUserRepository;

@Service
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
		// TODO Auto-generated method stub
		
	}

	public User getOneByUsername(String username) throws SQLException 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
