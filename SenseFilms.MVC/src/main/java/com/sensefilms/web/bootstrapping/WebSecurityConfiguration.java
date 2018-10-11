package com.sensefilms.web.bootstrapping;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;

public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception
	{
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
				.antMatchers("/login")
				.permitAll()
				.antMatchers("/", "/*ToDo*/")
				.access("hasRole('USER')")
				.and().formLogin();
	}
}
