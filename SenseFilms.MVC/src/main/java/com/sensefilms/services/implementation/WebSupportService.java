package com.sensefilms.services.implementation;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.sensefilms.business.entities.WebMenuItem;
import com.sensefilms.services.contracts.IWebSupportService;

@Service
public class WebSupportService implements IWebSupportService 
{

	@Override
	public ArrayList<WebMenuItem> getAllWebMenuItems() 
	{
		return null;
	}

}
