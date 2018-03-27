package com.sensefilms.services.contracts;

import com.sensefilms.business.entities.User;
import com.sensefilms.common.exceptions.CustomHandledException;

public interface IAccountService 
{
	boolean tryAuthenticateUser(User user) throws CustomHandledException;
	
	boolean generateNewPassword(String username) throws CustomHandledException;
}
