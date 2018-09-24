package com.sensefilms.services.implementation;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensefilms.business.entities.WebMenuItem;
import com.sensefilms.common.exceptions.UiException;
import com.sensefilms.common.utils.CommonConstants;
import com.sensefilms.repositories.contracts.IWebSupportRepository;
import com.sensefilms.services.base.BaseService;
import com.sensefilms.services.contracts.IWebSupportService;

@Service
public class WebSupportService extends BaseService implements IWebSupportService 
{

	private IWebSupportRepository webSupportRepository;
	private static ArrayList<WebMenuItem> menuItems;
	
	@Autowired
	public WebSupportService(IWebSupportRepository webSupportRepository) 
	{
		super(WebSupportService.class);
		this.webSupportRepository = webSupportRepository;
	}
	
	@Override
	public ArrayList<WebMenuItem> getAllWebMenuItems() throws UiException 
	{
		try 
		{
			if(menuItems == null) 
			{
				menuItems = this.webSupportRepository.getAllWebMenuItems();
				getLogger().debug("Loaded menu items collections.");
			}
			
			return menuItems;
		}
		catch(HibernateException hex)
		{
			throw new UiException(CommonConstants.HIBERNATE_ERROR_MESSAGE, hex);
		}
		catch(Exception ex)
		{
			throw new UiException(CommonConstants.GENERIC_ERROR_MESSAGE, ex);
		}
	}

}
