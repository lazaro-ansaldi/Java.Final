package com.sensefilms.web.support;

import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sensefilms.core.extensions.StringExtensions;

@Component
public class WebUrisUtils 
{    	
	private static String domainName;
	
	public WebUrisUtils(@Value("${domain.name}") String domain) 
	{		
		domainName = domain;
	}
	
	/**
	 * Return the URL with the received param.
	 * @param baseUrl url to build.
	 * @param param param name.
	 * @param value value of the param.
	 * @return URL with the param-value received.
	 * @throws IllegalArgumentException if the param or the URL are empty.
	 */
	public static String getUrlWithParams(String baseUrl, String param, String value) throws IllegalArgumentException
	{
		if(StringExtensions.isNullOrEmpty(baseUrl)) throw new IllegalArgumentException("Base url is null or empty.");
		
		if(StringExtensions.isNullOrEmpty(param)) throw new IllegalArgumentException("The param name is null or empty.");
			
		return domainName + baseUrl + "?" + param + "=" + value;		
	}
	
	/**
	 * Return the URL with the received params.
	 * @param baseUrl url to build.
	 * @param params all the param-value pairs.
	 * @return URL with all the params received.
	 * @throws IllegalArgumentException if the params collection or the URL are empty.
	 */
	public static String getUrlWithParams(String baseUrl, HashMap<String, String> params) throws IllegalArgumentException
	{
		if(StringExtensions.isNullOrEmpty(baseUrl)) throw new IllegalArgumentException("Base url is null or empty.");
		
		if(params == null || params.isEmpty()) throw new IllegalArgumentException("The params map is null or empty.");
		
		String result = domainName + baseUrl + "?";
		
		result += params.entrySet().stream().map((entry) -> entry.getKey() + "=" + entry.getValue() + "&").collect(Collectors.joining());
	    
		// Remove the '&' at the end
		return result.substring(0, result.length() - 1);
	}
}
