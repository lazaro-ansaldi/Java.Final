package com.sensefilms.business.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.sensefilms.business.enums.UserRoles;

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
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "UserRole", nullable = false)
	private UserRoles userRole;
	
	@Column(name = "Email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "IsNewPassword", nullable = false)
	private boolean isNewPassword;
	
	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

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
	
	public String getCompleteName() 
	{
		return String.format("%s, %s", this.lastName, this.name);
	}
	
}
