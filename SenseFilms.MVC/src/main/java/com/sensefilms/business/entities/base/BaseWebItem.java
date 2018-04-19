package com.sensefilms.business.entities.base;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.sensefilms.business.enums.UserRoles;

@MappedSuperclass
public abstract class BaseWebItem extends BaseEntity 
{
	@Column(name = "ItemUrl")
	private String itemUrl;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "UserRole", nullable = false)
	private UserRoles userRole;

	@Column(name = "Description")
	private String description;

	
	public String getItemUrl() 
	{
		return itemUrl;
	}

	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}

	public UserRoles getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoles userRole) 
	{
		this.userRole = userRole;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}
}
