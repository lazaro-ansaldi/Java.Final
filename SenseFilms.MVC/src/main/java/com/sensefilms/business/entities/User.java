package com.sensefilms.business.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseEntity
{
	@Column(name = "Username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "Password", nullable = false)
	private String password;
	
	@Column(name = "LastLogin")
	private Date lastLogin;
	
	@Column(name = "Name", nullable = false)
	private String name;
	
	@Column(name = "LastName", nullable = false)
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
