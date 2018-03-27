package com.sensefilms.services.implementation;

import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensefilms.business.entities.User;
import com.sensefilms.common.exceptions.CustomHandledException;
import com.sensefilms.repositories.contracts.IUserRepository;
import com.sensefilms.services.contracts.IAccountService;

@Service
public class AccountService implements IAccountService 
{

	private Logger appLogger = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	public AccountService(IUserRepository userRepository) 
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
	
	public boolean generateNewPassword(String username) throws CustomHandledException
	{
		User currentUser;
		try 
		{
			currentUser = _userRepository.getOneByUsername(username);
			if(currentUser == null) return false;
			
			currentUser.setPassword(UUID.randomUUID().toString().toLowerCase().replace("-", ""));
			currentUser.setNewPassword(true);
			_userRepository.update(currentUser);
			
			appLogger.debug(String.format("Password regenerated for user %s", username));
			
			return true;
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
