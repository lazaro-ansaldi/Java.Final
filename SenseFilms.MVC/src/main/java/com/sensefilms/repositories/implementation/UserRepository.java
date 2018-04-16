package com.sensefilms.repositories.implementation;

import java.sql.SQLException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sensefilms.business.entities.User;
import com.sensefilms.common.helpers.CastHelper;
import com.sensefilms.repositories.base.BaseCRUDRepository;
import com.sensefilms.repositories.contracts.IUserRepository;

@Repository
@Transactional
public class UserRepository extends BaseCRUDRepository<User> implements IUserRepository
{
	public UserRepository()
	{
		super(User.class);
	}

	@Override
	public void insert(User user) throws SQLException 
	{
		super.insert(user);	
	}

	@Override
	public User getOneById(int id) throws SQLException 
	{
		return super.getOneById(id);
	}

	@Override
	public void update(User user) throws SQLException 
	{
		super.update(user);	
	}

	@Override
	public void deleteOneById(int id) throws SQLException 
	{
		super.deleteOneById(id);
	}

	@Override
	public User getOneByUsername(String username) throws SQLException 
	{
		Query query = getSessionFactory().getCurrentSession().createQuery("from User where username = :username");
		query.setParameter("username", username);
		return CastHelper.tryCastAs(User.class, query.uniqueResult());
	}

}
