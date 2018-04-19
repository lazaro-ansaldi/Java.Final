package com.sensefilms.business.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sensefilms.business.entities.base.BaseEntity;

@Entity
@Table(name = "audit_event")
public class AuditEvent extends BaseEntity
{
	@Column(name = "Description")
	private String description;
	
	@Column(name = "Event", nullable = false)
	private String event;
	
	@Column(name = "CreatedOn", nullable = false)
	private Date createdOn;
	
	@Column(name = "Comments")
	private String comments;

	public AuditEvent(String description, String event, String comments) 
	{
		this.description = description;
		this.event = event;
		this.comments = comments;
		this.createdOn = new Date();
	}
	
	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getEvent() 
	{
		return event;
	}

	public void setEvent(String event) 
	{
		this.event = event;
	}

	public Date getCreatedOn() 
	{
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) 
	{
		this.createdOn = createdOn;
	}

	public String getComments() 
	{
		return comments;
	}

	public void setComments(String comments) 
	{
		this.comments = comments;
	}
	
	
}
