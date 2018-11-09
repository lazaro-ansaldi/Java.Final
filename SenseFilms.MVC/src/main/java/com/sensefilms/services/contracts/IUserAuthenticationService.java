package com.sensefilms.services.contracts;

import com.sensefilms.business.entities.User;
import com.sensefilms.core.exceptions.UiException;
import com.sensefilms.core.exceptions.UiNotAuthenticatedException;

public interface IUserAuthenticationService
{	
	void updateNewPassord(String username, String newPassword) throws UiNotAuthenticatedException, UiException;
	
	void addNewUser(User user) throws UiException;
}
