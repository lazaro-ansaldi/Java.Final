package com.sensefilms.common.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationHandler 
{
	
	public static String getPropertieValue(String propName) throws IOException
	{
		String fileName = "configuration.properties";
		InputStream inputStream=null;		 
		Properties prop;
				
		try 
		{
			prop = new Properties();
			inputStream = new FileInputStream(fileName);
			prop.load(inputStream);
			return prop.getProperty(propName);
		}
		catch(FileNotFoundException fnfex) 
		{
			throw fnfex;
		}
		catch(IOException ioex) 
		{
			throw ioex;
		}
		finally 
		{
			if(inputStream!=null) 
			{
				inputStream.close();
			}
		}
	}
}