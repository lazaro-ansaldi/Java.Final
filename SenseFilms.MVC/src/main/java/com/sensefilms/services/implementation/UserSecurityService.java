package com.sensefilms.services.implementation;

import java.sql.SQLException;

import javax.mail.MessagingException;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sensefilms.business.entities.User;
import com.sensefilms.common.exceptions.UiNotAuthenticatedException;
import com.sensefilms.common.exceptions.UiException;
import com.sensefilms.common.handlers.IAuditHandler;
import com.sensefilms.common.handlers.IAuthenticationContext;
import com.sensefilms.common.handlers.IMailHandler;
import com.sensefilms.common.utils.CommonConstants;
import com.sensefilms.common.utils.StringUtils;
import com.sensefilms.repositories.contracts.IUserRepository;
import com.sensefilms.services.base.BaseService;
import com.sensefilms.services.contracts.IUserSecurityService;

@Service
public final class UserSecurityService extends BaseService implements IUserSecurityService, UserDetailsService
{
	private IAuthenticationContext _authenticationContext;
	private IMailHandler _mailHandler;
	private IAuditHandler _auditHandler;

	@Autowired
	public UserSecurityService(IUserRepository userRepository, IMailHandler mailHandler, IAuditHandler auditHandler, IAuthenticationContext authenticationContext)
	{
		super(UserSecurityService.class);
		this._userRepository = userRepository;
		this._mailHandler = mailHandler;
		this._auditHandler = auditHandler;
		this._authenticationContext = authenticationContext;
	}

	private IUserRepository _userRepository;

	@Override
	public void updateNewPassord(String username, String newPassword) throws UiNotAuthenticatedException, UiException
	{
		User currentUser = null;
		boolean isRecoveryProcess = StringUtils.isNullOrEmpty(newPassword);

		try
		{
			currentUser = _userRepository.getOneByUsername(username);

			if (currentUser == null)
				throw new UiNotAuthenticatedException("The username doesn't exists.");

			if (isRecoveryProcess)
				newPassword = StringUtils.getRandomStringBasedOnGuid(10);

			currentUser.setPassword(newPassword);
			currentUser.setNewPassword(isRecoveryProcess);
			_userRepository.update(currentUser);
			getLogger().debug(String.format("Password regenerated for user %s", username));

			// Send an email with the temporary password
			if (isRecoveryProcess)
				sendEmailWithNewPassword(newPassword, currentUser.getEmail());

			auditPasswordChange(isRecoveryProcess, currentUser.getUsername());
		} 
		catch (UiNotAuthenticatedException authEx)
		{
			throw authEx;
		} 
		catch (HibernateException hex)
		{
			throw new UiException(CommonConstants.HIBERNATE_ERROR_MESSAGE, hex);
		} 
		catch (MessagingException msgEx)
		{
			throw new UiException(String.format("An error ocurred when try send an email to the addres %s.", currentUser.getEmail()), msgEx);
		} 
		catch (Exception ex)
		{
			throw new UiException(CommonConstants.GENERIC_ERROR_MESSAGE, ex);
		}
	}

	@Override
	public void addNewUser(User user) throws UiException
	{
		try
		{
			this._userRepository.insert(user);
		} 
		catch (HibernateException hex)
		{
			throw new UiException(CommonConstants.HIBERNATE_ERROR_MESSAGE, hex);
		} 
		catch (Exception ex)
		{
			throw new UiException(CommonConstants.GENERIC_ERROR_MESSAGE, ex);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User currentUser = null;
		try
		{
			currentUser = _userRepository.getOneByUsername(username);
		}
		catch (SQLException sqlEx)
		{
			return null;
		}

		return _authenticationContext.mapToSpringUser(currentUser);
	}
	
	private void auditPasswordChange(boolean isRecoveryProcess, String username)
	{
		String eventDescription = isRecoveryProcess ? String.format("Random password generated for user %s", username)
					: String.format("Password updated for user %s", username);

		this._auditHandler.handleNewAuditEvent("[Update-Password]", eventDescription, StringUtils.EMPTY);
	}

	private void sendEmailWithNewPassword(String randomPassword, String email) throws MessagingException
	{
		String emailBodyText = String.format("This is your new password \"%s\". ", randomPassword);
		try
		{
			_mailHandler.sendMailMessage(email, "Password Recover", emailBodyText);
		} 
		catch (MessagingException msgEx)
		{
			throw msgEx;
		}
		getLogger().debug(String.format("Email send to %s succesfully.", email));
	}
}
