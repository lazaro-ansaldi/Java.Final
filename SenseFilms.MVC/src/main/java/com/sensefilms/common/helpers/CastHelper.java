package com.sensefilms.common.helpers;

public class CastHelper 
{
	public static <T> T tryCastAs(Class<T> clazz, Object o)
	{
	    if(clazz.isInstance(o))
	    {
	        return clazz.cast(o);
	    }
	    
	    return null;
	}
}
