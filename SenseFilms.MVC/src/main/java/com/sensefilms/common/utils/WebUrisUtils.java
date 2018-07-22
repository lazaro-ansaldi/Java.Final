package com.sensefilms.common.utils;

import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WebUrisUtils 
{    	
	private static String domainName;
	
	public WebUrisUtils(@Value("${domain.name}") String domain) 
	{		
		domainName = domain;
	}
	
	public static String getUrlWithParams(String baseUrl, String param, String value) throws IllegalArgumentException
	{
		if(StringUtils.isNullorEmpty(baseUrl)) throw new IllegalArgumentException("Base url is null or empty.");
		
		if(StringUtils.isNullorEmpty(param)) throw new IllegalArgumentException("The param name is null or empty.");
			
		return domainName + baseUrl + "?" + param + "=" + value;		
	}
	
	public static String getUrlWithParams(String baseUrl, HashMap<String, String> params) throws IllegalArgumentException
	{
		if(StringUtils.isNullorEmpty(baseUrl)) throw new IllegalArgumentException("Base url is null or empty.");
		
		if(params == null || params.isEmpty()) throw new IllegalArgumentException("The params map is null or empty.");
		
		String result = domainName + baseUrl + "?";
		
		result += params.entrySet().stream().map((entry) -> entry.getKey() + "=" + entry.getValue() + "&").collect(Collectors.joining());
	    
		// Remove the '&' at the end
		return result.substring(0, result.length() - 1);
	}
}
