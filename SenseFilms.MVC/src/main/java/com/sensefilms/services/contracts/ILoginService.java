package com.sensefilms.services.contracts;

import com.sensefilms.business.entities.User;

public interface ILoginService 
{
	boolean tryAuthenticateUser(User user);
}
