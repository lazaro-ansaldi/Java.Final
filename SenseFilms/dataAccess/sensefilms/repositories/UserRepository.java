package sensefilms.repositories;

import java.sql.SQLException;
import sensefilms.entities.User;
import sensefilms.interfaces.IUserRepository;

public class UserRepository implements IUserRepository {

	@Override
	public void insert(User entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getOneById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOneById(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getOneByUsername(String username) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
