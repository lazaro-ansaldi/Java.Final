package com.sensefilms.core.extensions;

import java.util.UUID;

public class StringExtensions 
{
	/**
	 * Check if a string is null or empty.
	 * @param input string to verify.
	 * @return true if the string is empty or null.
	 */
	public static boolean isNullOrEmpty(String input) 
	{
		return (input == null || input.isEmpty());
	}
	
	/**
	 * Generates a random string based on a Guid
	 * @param stringLength length of the string.
	 * @return generated string.
	 */
	public static String getRandomStringBasedOnGuid(int stringLength) 
	{
		return UUID.randomUUID().toString().toLowerCase().replace("-", "").substring(0, stringLength);
	}
	
	public static final String EMPTY = "";
}
