package com.sensefilms.services.contracts;

import com.sensefilms.core.exceptions.UiException;
import com.sensefilms.core.exceptions.UiNotAuthenticatedException;
import com.sensefilms.repositories.entities.User;

public interface IUserAuthenticationService
{	
	void updateNewPassord(String username, String newPassword) throws UiNotAuthenticatedException, UiException;
	
	void addNewUser(User user) throws UiException;
}
