package com.sensefilms.repositories.implementation;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sensefilms.core.extensions.CastUtils;
import com.sensefilms.repositories.base.BaseRepository;
import com.sensefilms.repositories.contracts.IWebSupportRepository;
import com.sensefilms.repositories.entities.WebMenuItem;

@Repository
@Transactional
public class WebSupportRepository extends BaseRepository implements IWebSupportRepository 
{

	@Override
	public List<WebMenuItem> getAllWebMenuItems()
	{
		return CastUtils.castList(WebMenuItem.class, getCriteria(WebMenuItem.class).list());
	}

}
