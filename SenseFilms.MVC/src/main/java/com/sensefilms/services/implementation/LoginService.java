package com.sensefilms.services.implementation;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensefilms.common.entities.User;
import com.sensefilms.repositories.contracts.IUserRepository;
import com.sensefilms.services.contracts.ILoginService;

@Service
public class LoginService implements ILoginService 
{

	@Autowired
	public LoginService(IUserRepository userRepository) 
	{
		this._userRepository = userRepository;
	}
	
	private IUserRepository _userRepository;
	
	
	public boolean tryAuthenticateUser(User user) 
	{
		try 
		{
			User dbUser = _userRepository.getOneByUsername(user.getUsername());
			
			if(dbUser != null && dbUser.getUsername().equals(user.getUsername()) && 
					dbUser.getPassword().equals(user.getPassword())) 
			{
				dbUser.setLastLogin(new Date());
				_userRepository.update(dbUser);
				return true;
			}
			
			return false;
		}
		catch(SQLException sqlex) 
		{
			// Do nothing			
		}
		return false;
	}

	
}
