package com.sensefilms.services.contracts;

import com.sensefilms.business.entities.User;
import com.sensefilms.common.exceptions.UiNotAuthenticatedException;
import com.sensefilms.common.exceptions.UiException;

public interface IAccountService 
{
	void tryAuthenticateUser(User user) throws UiNotAuthenticatedException, UiException; 
	
	void updateNewPassord(String username, String newPassword) throws UiNotAuthenticatedException, UiException;
	
	void addNewUser(User user) throws UiException;
}
