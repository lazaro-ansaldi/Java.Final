package com.sensefilms.web.bootstrapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception
	{
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
        http
        .authorizeRequests()
            .antMatchers("/favicon.ico", "/resources/**", "/signup", "/about", "/signIn").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/signIn")
            .permitAll()
            .failureUrl("/signIn?error=1")
            .loginProcessingUrl("/authenticate-spring")
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
        .logout()
            .logoutUrl("/logout")
            .permitAll()
            .logoutSuccessUrl("/signin?logout");
//            .and()
//        .rememberMe()
//            .rememberMeServices(rememberMeServices())
//            .key("remember-me-key");
	}	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception 
	{
		//auth.userDetailsService(userDetailsService)
	}
}
