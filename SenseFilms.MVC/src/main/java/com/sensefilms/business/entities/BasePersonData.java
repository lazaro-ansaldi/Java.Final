package com.sensefilms.business.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BasePersonData extends BaseEntity
{
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
