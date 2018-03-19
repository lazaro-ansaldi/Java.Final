package com.sensefilms.services.contracts;

import com.sensefilms.common.entities.User;

public interface ILoginService 
{
	boolean tryAuthenticateUser(User user);
}
