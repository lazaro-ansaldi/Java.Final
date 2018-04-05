package com.sensefilms.repositories.contracts;

import java.util.ArrayList;

import com.sensefilms.business.entities.WebMenuItem;

public interface IWebSupportRepository 
{
	ArrayList<WebMenuItem> getAllWebMenuItems();
}
