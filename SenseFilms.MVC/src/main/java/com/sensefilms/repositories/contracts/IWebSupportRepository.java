package com.sensefilms.repositories.contracts;

import java.util.ArrayList;

import com.sensefilms.repositories.entities.WebMenuItem;

public interface IWebSupportRepository 
{
	ArrayList<WebMenuItem> getAllWebMenuItems();
}
