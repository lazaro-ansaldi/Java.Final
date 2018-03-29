package com.sensefilms.services.contracts;

import com.sensefilms.business.entities.User;
import com.sensefilms.common.exceptions.CustomHandledException;

public interface IAccountService 
{
	boolean tryAuthenticateUser(User user) throws CustomHandledException;
	
	User getAuthenticatedUser(String username); 
	
	boolean updateNewPassord(String username, String newPassword) throws CustomHandledException;
}
