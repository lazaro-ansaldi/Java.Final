package sensefilms.repositories;

import sensefilms.entities.BaseEntity;
import sensefilms.entities.User;
import sensefilms.interfaces.IUserRepository;

public class UserRepository implements IUserRepository {

	@Override
	public <T extends BaseEntity> void insert(T entity) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public <T extends BaseEntity> T getOneById(int id) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends BaseEntity> void update(T entity) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOneById(int id) 
	{
		// TODO Auto-generated method stub

	}
	
	@Override
	public User getOneByUsername(String username) 
	{
		return new User();
	}

}
