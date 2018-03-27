package com.sensefilms.services.implementation;

import java.sql.SQLException;
import java.util.Date;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensefilms.business.entities.User;
import com.sensefilms.common.exceptions.CustomHandledException;
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
	
	
	public boolean tryAuthenticateUser(User user) throws CustomHandledException 
	{
		try 
		{
			User dbUser = _userRepository.getOneByUsername(user.getUsername());
			
			if(dbUser != null && dbUser.getPassword().equals(user.getPassword())) 
			{
				dbUser.setLastLogin(new Date());
				_userRepository.update(dbUser);
				return true;
			}
			
			return false;
		}
		catch(HibernateException hex)
		{
			throw new CustomHandledException("An error ocurred when try to access the database.", hex);
		}
		catch(SQLException sqlex) 
		{
			throw new CustomHandledException("An error ocurred when try to connect to the database.", sqlex);			
		}
		catch(Exception ex)
		{
			throw new CustomHandledException("A totally unexpected error occurred. Please run as fast as you can!", ex);
		}
	}
	
}
