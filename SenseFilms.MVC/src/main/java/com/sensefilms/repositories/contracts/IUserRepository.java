package com.sensefilms.repositories.contracts;

import java.sql.SQLException;

import com.sensefilms.business.entities.User;
import com.sensefilms.repositories.base.IBaseCRUDRepository;

public interface IUserRepository extends IBaseCRUDRepository<User>
{
	public User getOneByUsername(String username) throws SQLException;
}
