package com.sensefilms.common.utils;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class JsonSerializer 
{	
	/**
	 * Serialize the public getters of the received object
	 * to a Json file.
	 * @param o object to serialize.
	 * @return serialized Json content.
	 */
	public static String serializeAsJson(Object o)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		String result = StringUtils.EMPTY;
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
	
	/**
	 * Serialize the public getters of all the items in the received list
	 * to a Json file.
	 * @param o objects to serialize.
	 * @return serialized Json content.
	 */
	public static String serializeAsJson(ArrayList<Object> o)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		String result = StringUtils.EMPTY;
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
