package com.sensefilms.services.implementation;

import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

import javax.mail.MessagingException;

import org.hibernate.HibernateException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensefilms.business.entities.User;
import com.sensefilms.common.exceptions.CustomHandledException;
import com.sensefilms.common.handlers.IMailHandler;
import com.sensefilms.repositories.contracts.IUserRepository;
import com.sensefilms.services.contracts.IAccountService;

@Service
public class AccountService implements IAccountService 
{

	private Logger appLogger = LoggerFactory.getLogger(AccountService.class);
	private IMailHandler mailHandler;
	
	@Autowired
	public AccountService(IUserRepository userRepository, IMailHandler mailHandler) 
	{
		this._userRepository = userRepository;
		this.mailHandler = mailHandler;
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
		User currentUser = null;
		try 
		{
			currentUser = _userRepository.getOneByUsername(username);
			if(currentUser == null) return false;
			
			//Generate a 10 chars random password based on a Guid
			String randomPassword = UUID.randomUUID().toString().toLowerCase().replace("-", "").substring(0, 10);
			currentUser.setPassword(randomPassword);
			currentUser.setNewPassword(true);
			_userRepository.update(currentUser);
			appLogger.debug(String.format("Password regenerated for user %s", username));
			
			String emailBodyText = String.format("This is your new password \"%s\". ", randomPassword);
			mailHandler.sendMailMessage(currentUser.getEmail(), emailBodyText, "Password Recover");		
			appLogger.debug(String.format("Email send to %s succesfully.", currentUser.getEmail()));
			
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
		catch(MessagingException msgEx) 
		{
			throw new CustomHandledException(String.format("An error ocurred when try send an email to the addres %s.", currentUser.getEmail()), msgEx);	
		}
		catch(Exception ex)
		{
			throw new CustomHandledException("A totally unexpected error occurred. Please run as fast as you can!", ex);
		}
	}	
}