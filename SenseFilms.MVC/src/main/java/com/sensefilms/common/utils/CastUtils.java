package com.sensefilms.common.utils;

public class CastUtils 
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
