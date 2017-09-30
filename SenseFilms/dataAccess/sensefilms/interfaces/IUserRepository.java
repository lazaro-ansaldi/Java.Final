package sensefilms.interfaces;

import sensefilms.entities.User;

public interface IUserRepository extends IBaseRepository 
{
	public User getOneByUsername(String username);
}
