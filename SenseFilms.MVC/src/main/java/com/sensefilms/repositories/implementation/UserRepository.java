package com.sensefilms.repositories.implementation;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.sensefilms.common.entities.User;
import com.sensefilms.repositories.contracts.IUserRepository;

@Service
public class UserRepository implements IUserRepository
{

	@Override
	public void insert(User entity) throws SQLException 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getOneById(int id) throws SQLException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User entity) throws SQLException 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOneById(int id) throws SQLException 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getOneByUsername(String username) throws SQLException 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
