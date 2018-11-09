package com.sensefilms.core.utilities;

import com.sensefilms.core.exceptions.UiNotAuthenticatedException;
import com.sensefilms.repositories.entities.User;

public interface IAuthenticationContext
{
	String getLoggedUsername() throws UiNotAuthenticatedException;
	
	org.springframework.security.core.userdetails.User mapToSpringUser(User user);
	
	boolean isLoggedIn();
}
