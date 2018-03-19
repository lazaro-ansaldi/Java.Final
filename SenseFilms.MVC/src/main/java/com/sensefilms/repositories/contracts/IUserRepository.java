package com.sensefilms.repositories.contracts;

import java.sql.SQLException;

import com.sensefilms.common.entities.User;

public interface IUserRepository extends IBaseRepository<User>
{
	public User getOneByUsername(String username) throws SQLException;
}
