package sensefilms.repositories;

import java.sql.SQLException;

import sensefilms.entities.BaseEntity;
import sensefilms.entities.User;
import sensefilms.interfaces.IUserRepository;

public class UserRepository implements IUserRepository {

	@Override
	public <T extends BaseEntity> void insert(T entity) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public <T extends BaseEntity> T getOneById(int id)  throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends BaseEntity> void update(T entity) throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOneById(int id)  throws SQLException
	{
		// TODO Auto-generated method stub

	}
	
	@Override
	public User getOneByUsername(String username) throws SQLException
	{
		return new User();
	}

}
