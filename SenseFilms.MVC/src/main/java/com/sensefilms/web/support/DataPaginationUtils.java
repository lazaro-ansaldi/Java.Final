package com.sensefilms.web.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.support.PagedListHolder;

public class DataPaginationUtils<T extends Object>
{
	private PagedListHolder<T> pagedListHolder;
	
	private int totalPages;
	
	public DataPaginationUtils(ArrayList<T> data) 
	{
		this.pagedListHolder = new PagedListHolder<T>(data);
	}
	
	public int getTotalPages() 
	{
		return this.totalPages;
	}
	
	public List<T> getCurrentPageData(int pageSize, int currentPage) 
	{		
		pagedListHolder.setPageSize(pageSize);
		this.totalPages = pagedListHolder.getPageCount();

		// Set default value for pageSize as 1
		if (currentPage < 1 || currentPage > pagedListHolder.getPageCount())
		{
				pagedListHolder.setPage(0);
		}
		else if (currentPage <= pagedListHolder.getPageCount())
		{
				pagedListHolder.setPage(currentPage - 1);
		}

		return pagedListHolder.getPageList();
	}
}
