package sensefilms.interfaces;

import sensefilms.entities.User;
import sensefilms.exceptions.LoggedException;

/*
 * Receives a user and validate if the credentials are ok or not.
 */
public interface ILoginLogic 
{
	public boolean isValidLogin(User user) throws LoggedException;
}
