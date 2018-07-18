package com.sensefilms.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.support.PagedListHolder;

public class DataPaginationUtils<T extends Object>
{
	private PagedListHolder<T> pagedListHolder;
	
	private int maxPages;
	
	public DataPaginationUtils(ArrayList<T> data) 
	{
		this.pagedListHolder = new PagedListHolder<T>(data);
	}
	
	public int getMaxPages() 
	{
		return this.maxPages;
	}
	
	public List<T> getCurrentPageData(int pageSize, int currentPage) 
	{		
		pagedListHolder.setPageSize(pageSize);
		this.maxPages = pagedListHolder.getPageCount();

		// Set default value for pageSize as 1
		if (pageSize < 1 || pageSize > pagedListHolder.getPageCount())
			pageSize = 1;

		if (pageSize < 1 || pageSize > pagedListHolder.getPageCount())
			pagedListHolder.setPage(0);

		else if (pageSize <= pagedListHolder.getPageCount())
			pagedListHolder.setPage(pageSize - 1);

		return pagedListHolder.getPageList();
	}
}
