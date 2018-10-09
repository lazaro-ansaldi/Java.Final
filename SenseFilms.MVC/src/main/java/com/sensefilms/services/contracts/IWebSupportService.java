package com.sensefilms.services.contracts;

import java.util.List;

import com.sensefilms.business.entities.WebMenuItem;
import com.sensefilms.business.enums.UserRoles;
import com.sensefilms.common.exceptions.UiException;

public interface IWebSupportService 
{
	public List<WebMenuItem> getAllowedWebMenuItems(UserRoles userRole) throws UiException;
}
