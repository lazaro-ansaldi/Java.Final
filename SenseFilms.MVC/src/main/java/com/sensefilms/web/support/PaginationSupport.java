package com.sensefilms.web.support;

import java.util.List;
import java.util.HashMap;

public class PaginationSupport<T extends Object>
{
	private final int MAX_PAGES_SHOW = 3;
	
	private int currentPage;
	
	private int pageSize;
	
	private DataPaginationUtils<T> paginationUtils;
	
	private String controllerUrl;
	
	public PaginationSupport(List<T> data, int pageSize, int currentPage, String controllerUrl) 
	{
		this.paginationUtils = new DataPaginationUtils<T>(data);
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.controllerUrl = controllerUrl;
	}

	public int getTotalPages() 
	{
		return this.paginationUtils.getTotalPages();
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
	
	public boolean isPreviousPage() 
	{
		return currentPage > 1;
	}
	
	public boolean isNextPage() 
	{
		return currentPage < getTotalPages();
	}
	
	public String getNextPageUrl() 
	{
		HashMap<String,String> urlParams = isNextPage() ? getUrlParams(this.currentPage + 1) : getUrlParams(this.currentPage);
		return WebUrisUtils.getUrlWithParams(this.controllerUrl, urlParams);
	}
	
	public String getPreviousPageUrl() 
	{
		HashMap<String,String> urlParams = isPreviousPage() ? getUrlParams(this.currentPage - 1) : getUrlParams(this.currentPage);
		return WebUrisUtils.getUrlWithParams(this.controllerUrl, urlParams);
	}
	
	public HashMap<Integer,String> getNextPagesNumbers()
	{
		HashMap<Integer,String> pages = new HashMap<Integer,String>();
		int pageToShow = currentPage + 1;
		while(pages.size() < MAX_PAGES_SHOW && pageToShow <= getTotalPages()) 
		{
			HashMap<String, String> urlParams = getUrlParams(pageToShow);
			pages.put(pageToShow, WebUrisUtils.getUrlWithParams(this.controllerUrl, urlParams));
			pageToShow++;
		}

		return pages;	
	}	
	
	public HashMap<Integer,String> getPreviousPagesNumbers()
	{
		HashMap<Integer,String> pages = new HashMap<Integer,String>();
		int pageToShow = currentPage - 1;
		while(pages.size() < MAX_PAGES_SHOW && pageToShow > 0) 
		{
			HashMap<String, String> urlParams = getUrlParams(pageToShow);
			pages.put(pageToShow, WebUrisUtils.getUrlWithParams(this.controllerUrl, urlParams));
			pageToShow--;
		}

		return pages;	
	}
	
	private HashMap<String, String> getUrlParams(int page)
	{
		HashMap<String,String> urlParams = new HashMap<String, String>();
		urlParams.put("pageSize", String.valueOf(this.pageSize));
		urlParams.put("currentPage", String.valueOf(page));
		return urlParams;
	}
}
