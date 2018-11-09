package com.sensefilms.repositories.contracts;

import java.sql.SQLException;

import com.sensefilms.repositories.base.IBaseCRUDRepository;
import com.sensefilms.repositories.entities.User;

public interface IUserRepository extends IBaseCRUDRepository<User>
{
	public User getOneByUsername(String username) throws SQLException;
}
