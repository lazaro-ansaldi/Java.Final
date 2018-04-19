package com.sensefilms.business.entities.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BasePersonData extends BaseEntity
{
	@Column(name = "Name", nullable = false)
	private String name;
	
	@Column(name = "LastName", nullable = false)
	private String lastName;
	
	@Column(name = "Email", nullable = false, unique = true)
	private String email;
	
	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
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
	
	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
}
