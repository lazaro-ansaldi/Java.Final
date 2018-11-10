package com.sensefilms.web.bootstrapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.sensefilms.services.contracts.IUserSecurityService;;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Autowired
	private IUserSecurityService userAuthenticationService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
        http
        .authorizeRequests()
            .antMatchers("/favicon.ico", "/resources/**", "/signIn", "/AccountController/forgotPassword", "/AccountController/sendNewPassword")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
        .formLogin()
            .loginPage("/signIn?error")
            .permitAll()
            .usernameParameter("username")
            .passwordParameter("password")
            .successForwardUrl("/signIn")
            .failureForwardUrl("/signIn/error=auth_failure")
            .and()
        .logout()
            .logoutUrl("/logout")
            .permitAll()
            .logoutSuccessUrl("/signin?logout")
            .and()
        .csrf();
//            .and()
//        .rememberMe()
//            .rememberMeServices(rememberMeServices())
//            .key("remember-me-key");
	}	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.userDetailsService((UserDetailsService) userAuthenticationService);
	}
}
