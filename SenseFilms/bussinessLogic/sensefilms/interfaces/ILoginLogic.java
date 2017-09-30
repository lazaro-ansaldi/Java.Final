package sensefilms.interfaces;

import sensefilms.entities.User;
import sensefilms.exceptions.LoggedException;

public interface ILoginLogic 
{
	public boolean isValidLogin(User user) throws LoggedException;
}
