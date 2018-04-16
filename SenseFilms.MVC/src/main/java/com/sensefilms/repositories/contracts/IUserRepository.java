package com.sensefilms.repositories.contracts;

import java.sql.SQLException;

import com.sensefilms.business.entities.User;
import com.sensefilms.repositories.base.IBaseRepository;

public interface IUserRepository extends IBaseRepository<User>
{
	public User getOneByUsername(String username) throws SQLException;
}
