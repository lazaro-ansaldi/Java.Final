package sensefilms.interfaces;

import java.sql.SQLException;

import sensefilms.entities.User;

public interface IUserRepository extends IBaseRepository<User>
{
	public User getOneByUsername(String username) throws SQLException;
}
