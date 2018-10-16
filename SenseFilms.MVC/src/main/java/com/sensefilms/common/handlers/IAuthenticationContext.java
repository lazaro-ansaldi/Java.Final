package com.sensefilms.common.handlers;

import com.sensefilms.business.entities.User;
import com.sensefilms.common.exceptions.UiNotAuthenticatedException;

public interface IAuthenticationContext
{
	String getLoggedUsername() throws UiNotAuthenticatedException;
	
	org.springframework.security.core.userdetails.User mapToSpringUser(User user);
	
	boolean isLoggedIn();
}
