package com.sensefilms.common.helpers;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class JsonSerializer 
{	
	public static String serializeAsJson(Object o)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		String result = StringHelper.EMPTY;
		try 
		{
			result = objectMapper.writeValueAsString(o);
		} 
		catch (JsonProcessingException jsonEx) 
		{
			jsonEx.printStackTrace();
		}	
		
		return result;
	}
	
	public static String serializeAsJson(ArrayList<Object> o)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		String result = StringHelper.EMPTY;
		try 
		{
			result = objectMapper.writeValueAsString(o);
		} 
		catch (JsonProcessingException jsonEx) 
		{
			jsonEx.printStackTrace();
		}	
		
		return result;
	}
}
