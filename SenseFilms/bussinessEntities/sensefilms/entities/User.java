package sensefilms.entities;

import java.util.Date;
import sensefilms.enums.UserRoles;

public class User extends BaseEntity
{
	private String username;
	private String password;
	private Date lastLogin;
	private String name;
	private UserRoles userRole;
	
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
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
}
