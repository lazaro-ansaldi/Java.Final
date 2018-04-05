package com.sensefilms.services.contracts;

import java.util.ArrayList;

import com.sensefilms.business.entities.WebMenuItem;
import com.sensefilms.common.exceptions.CustomHandledException;

public interface IWebSupportService 
{
	ArrayList<WebMenuItem> getAllWebMenuItems() throws CustomHandledException;
}
