package com.sensefilms.common.utils;

import java.util.UUID;

public class StringUtils 
{
	public static boolean isNullorEmpty(String input) 
	{
		return (input == null || input.isEmpty());
	}
	
	public static String getRandomStringBasedOnGuid(int stringLength) 
	{
		return UUID.randomUUID().toString().toLowerCase().replace("-", "").substring(0, stringLength);
	}
	
	public static final String EMPTY = "";
}
