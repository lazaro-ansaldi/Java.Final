package com.sensefilms.common.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class BaseEntity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public int getId() 
	{
		return this.id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
}
