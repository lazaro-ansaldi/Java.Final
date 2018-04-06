package com.sensefilms.services.implementation;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.mail.MessagingException;

import org.hibernate.HibernateException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensefilms.business.entities.User;
import com.sensefilms.common.exceptions.CustomHandledException;
import com.sensefilms.common.handlers.IAuditHandler;
import com.sensefilms.common.handlers.IMailHandler;
import com.sensefilms.common.helpers.StringHelper;
import com.sensefilms.repositories.contracts.IUserRepository;
import com.sensefilms.services.contracts.IAccountService;

@Service
public class AccountService implements IAccountService 
{

	private Logger appLogger = LoggerFactory.getLogger(AccountService.class);
	private IMailHandler mailHandler;
	private IAuditHandler auditHandler;
	private static HashMap<String, User> authenticatedUsers = new HashMap<String, User>();
	
	@Autowired
	public AccountService(IUserRepository userRepository, IMailHandler mailHandler, IAuditHandler auditHandler) 
	{
		this._userRepository = userRepository;
		this.mailHandler = mailHandler;
		this.auditHandler = auditHandler;
	}
	
	private IUserRepository _userRepository;
	
	@Override
	public boolean tryAuthenticateUser(User user) throws CustomHandledException 
	{
		try 
		{
			User dbUser = _userRepository.getOneByUsername(user.getUsername());
			
			if(dbUser != null && dbUser.getPassword().equals(user.getPassword())) 
			{
				dbUser.setLastLogin(new Date());
				_userRepository.update(dbUser);
				addUserToCache(dbUser);
				
				return true;
			}			
			
			return false;
		}
		catch(HibernateException hex)
		{
			throw new CustomHandledException("An error ocurred when try to access the database.", hex);
		}
		catch(Exception ex)
		{
			throw new CustomHandledException("A totally unexpected error occurred. Please run as fast as you can!", ex);
		}
	}
	
	@Override
	public boolean updateNewPassord(String username, String newPassword) throws CustomHandledException
	{
		User currentUser = null;
		boolean isRecoveryProcess = StringHelper.isNullorEmpty(newPassword);
		
		try 
		{
			currentUser = _userRepository.getOneByUsername(username);
			if(currentUser == null) return false;
			
			//Generate a 10 chars random password based on a Guid
			if(isRecoveryProcess)
				newPassword = UUID.randomUUID().toString().toLowerCase().replace("-", "").substring(0, 10);
							 
			currentUser.setPassword(newPassword);
			currentUser.setNewPassword(isRecoveryProcess);
			_userRepository.update(currentUser);
			appLogger.debug(String.format("Password regenerated for user %s", username));
			
			//Send an email with the temporary password
			if(isRecoveryProcess)
				sendEmailWithNewPassword(newPassword, currentUser.getEmail());
			
			auditPasswordChange(isRecoveryProcess, currentUser.getUsername());
			
			return true;
		}
		catch(HibernateException hex)
		{
			throw new CustomHandledException("An error ocurred when try to access the database.", hex);
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

	@Override
	public void addNewUser(User user) throws CustomHandledException 
	{
		try
		{
			this._userRepository.insert(user);
		}
		catch(HibernateException hex)
		{
			throw new CustomHandledException("An error ocurred when try to access the database.", hex);
		}
		catch(Exception ex)
		{
			throw new CustomHandledException("A totally unexpected error occurred. Please run as fast as you can!", ex);
		}
	}
	
	public static User getAuthenticatedUserByUsername(String username)
	{
		return authenticatedUsers.get(username);
	}
	
	// PRIVATE HELPERS METHODS //
	private void addUserToCache(User user) 
	{
		if(!authenticatedUsers.containsKey(user.getUsername()))
			authenticatedUsers.remove(user.getUsername());
		
		authenticatedUsers.put(user.getUsername(), user);
	}
	
	private void auditPasswordChange(boolean isRecoveryProcess, String username) 
	{
		String eventDescription = isRecoveryProcess ? String.format("Random password generated for user %s", username)
				: String.format("Password updated for user %s", username);
		
		this.auditHandler.handleNewAuditEvent("[Update-Password]", eventDescription, StringHelper.EMPTY);
	}
	
	private void sendEmailWithNewPassword(String randomPassword, String email) throws MessagingException 
	{
		String emailBodyText = String.format("This is your new password \"%s\". ", randomPassword);
		try 
		{
			mailHandler.sendMailMessage(email, "Password Recover", emailBodyText);
		} 
		catch (MessagingException msgEx) 
		{
			throw msgEx;
		}		
		appLogger.debug(String.format("Email send to %s succesfully.", email));
	}
	
}
