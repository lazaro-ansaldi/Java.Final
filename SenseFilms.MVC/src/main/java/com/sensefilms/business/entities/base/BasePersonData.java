package com.sensefilms.business.entities.base;

import java.util.Date;

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
	
	@Column(name = "CreatedOn", nullable = false)
	private Date createdOn;
	
	@Column(name = "IsActive", nullable = false)
	private boolean isActive;
	

	// Constructors
	public BasePersonData() 
	{
		if(this.createdOn == null)
			this.createdOn = new Date();
	}
	
	
	// Getters and Setters
	public boolean isActive()
	{
		return isActive;
	}

	public void setActive(boolean isActive)
	{
		this.isActive = isActive;
	}
	
	public Date getCreatedOn()
	{
		return createdOn;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

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
