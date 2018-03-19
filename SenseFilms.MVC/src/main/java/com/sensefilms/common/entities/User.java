package com.sensefilms.common.entities;

import java.util.Date;

public class User extends BaseEntity
{


	private String username;
	private String password;
	private Date lastLogin;
	private String name;
	private String lastName;
	
	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public Date getLastLogin() 
	{
		return lastLogin;
	}
	
	public void setLastLogin(Date lastLogin) 
	{
		this.lastLogin = lastLogin;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
}
