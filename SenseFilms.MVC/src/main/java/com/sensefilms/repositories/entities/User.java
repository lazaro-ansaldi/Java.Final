package com.sensefilms.repositories.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.sensefilms.core.enums.UserRoles;
import com.sensefilms.repositories.entities.base.BasePersonData;

@Entity
@Table(name = "user")
public class User extends BasePersonData
{
	@Column(name = "Username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "Password", nullable = false)
	private String password;
	
	@Column(name = "LastLogin")
	private Date lastLogin;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "UserRole", nullable = false)
	private UserRoles userRole;
	
	@Column(name = "IsNewPassword", nullable = false)
	private boolean isNewPassword;

	public boolean isNewPassword() 
	{
		return isNewPassword;
	}

	public void setNewPassword(boolean isNewPassword) 
	{
		this.isNewPassword = isNewPassword;
	}

	public UserRoles getUserRole() 
	{
		return userRole;
	}

	public void setUserRole(UserRoles userRole) 
	{
		this.userRole = userRole;
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
	
}
