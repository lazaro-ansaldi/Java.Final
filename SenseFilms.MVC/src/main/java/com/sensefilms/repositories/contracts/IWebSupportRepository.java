package com.sensefilms.repositories.contracts;

import java.util.List;

import com.sensefilms.repositories.entities.WebMenuItem;

public interface IWebSupportRepository 
{
	List<WebMenuItem> getAllWebMenuItems();
}
