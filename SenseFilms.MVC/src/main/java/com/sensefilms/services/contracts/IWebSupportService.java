package com.sensefilms.services.contracts;

import java.util.List;

import com.sensefilms.core.exceptions.UiException;
import com.sensefilms.repositories.entities.WebMenuItem;

public interface IWebSupportService 
{
	public List<WebMenuItem> getAllowedWebMenuItems(String userName) throws UiException;
}
