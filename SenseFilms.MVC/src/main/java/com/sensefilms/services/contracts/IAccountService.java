package com.sensefilms.services.contracts;

import com.sensefilms.business.entities.User;
import com.sensefilms.common.exceptions.CustomBusinessException;
import com.sensefilms.common.exceptions.CustomHandledException;

public interface IAccountService 
{
	void tryAuthenticateUser(User user) throws CustomBusinessException, CustomHandledException; 
	
	void updateNewPassord(String username, String newPassword) throws CustomBusinessException, CustomHandledException;
	
	void addNewUser(User user) throws CustomHandledException;
}
