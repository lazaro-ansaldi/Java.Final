package com.sensefilms.repositories.implementation;

import java.util.ArrayList;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sensefilms.business.entities.WebMenuItem;
import com.sensefilms.common.utils.CastUtils;
import com.sensefilms.repositories.base.BaseRepository;
import com.sensefilms.repositories.contracts.IWebSupportRepository;

@Repository
@Transactional
public class WebSupportRepository extends BaseRepository implements IWebSupportRepository 
{

	@Override
	public ArrayList<WebMenuItem> getAllWebMenuItems()
	{
		ArrayList<WebMenuItem> webMenuItems = new ArrayList<WebMenuItem>();
		
		Query query = getSessionFactory().getCurrentSession().createQuery("from WebMenuItem");
		for(Object o : query.list()) 
		{
			webMenuItems.add(CastUtils.tryCastAs(WebMenuItem.class, o));
		}
		//query.list().forEach( (x) -> webMenuItems.add(CastHelper.tryCastAs(WebMenuItem.class, x)) );
		
		return webMenuItems;
	}

}
