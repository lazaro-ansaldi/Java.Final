package com.sensefilms.web.support;

import java.util.ArrayList;
import java.util.List;

import com.sensefilms.common.utils.DataPaginationUtils;

public class PaginationSupport<T extends Object>
{
	private int currentPage;
	
	private int pageSize;
	
	private DataPaginationUtils<T> paginationUtils;
	
	public PaginationSupport(ArrayList<T> data, int pageSize, int currentPage) 
	{
		this.paginationUtils = new DataPaginationUtils<T>(data);
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}

	public int getMaxPages() 
	{
		return this.paginationUtils.getMaxPages();
	}
	
	public List<T> getData()
	{
		return paginationUtils.getCurrentPageData(this.pageSize, this.currentPage);
	}

	public int getCurrentPage()
	{
		return currentPage;
	}

	public int getPageSize()
	{
		return pageSize;
	}
	
	
}
