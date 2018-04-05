package com.sensefilms.services.implementation;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensefilms.business.entities.WebMenuItem;
import com.sensefilms.common.exceptions.CustomHandledException;
import com.sensefilms.repositories.contracts.IWebSupportRepository;
import com.sensefilms.services.contracts.IWebSupportService;

@Service
public class WebSupportService implements IWebSupportService 
{

	private IWebSupportRepository webSupportRepository;
	
	@Autowired
	public WebSupportService(IWebSupportRepository webSupportRepository) 
	{
		this.webSupportRepository = webSupportRepository;
	}
	
	@Override
	public ArrayList<WebMenuItem> getAllWebMenuItems() throws CustomHandledException 
	{
		try 
		{
			return this.webSupportRepository.getAllWebMenuItems();
		}
		catch(HibernateException hex)
		{
			throw new CustomHandledException("An error ocurred when try to access the database.", hex);
		}
		catch(Exception ex)
		{
			throw new CustomHandledException("A totally unexpected error occurred. Please run as fast as you can!", ex);
		}
	}

}
