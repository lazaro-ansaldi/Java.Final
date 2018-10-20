package com.sensefilms.common.handlers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.sensefilms.common.exceptions.UiNotAuthenticatedException;

@Component
public class AuthenticationContext implements IAuthenticationContext
{

	@Override
	public String getLoggedUsername() throws UiNotAuthenticatedException
	{
        Object userDetails = SecurityContextHolder.getContext()
        		.getAuthentication()
        		.getPrincipal();
        
        if (userDetails instanceof UserDetails) 
        {
            return ((UserDetails)userDetails).getUsername();
        }

        throw new UiNotAuthenticatedException("Cannot found current session");
	}

	@Override
	public User mapToSpringUser(com.sensefilms.business.entities.User user)
	{
		if(user == null) 
		{
			return null;
		}
		
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserRole().toString()));
        
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}

	@Override
	public boolean isLoggedIn()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		return !(auth == null || auth instanceof AnonymousAuthenticationToken);	
	}
}
