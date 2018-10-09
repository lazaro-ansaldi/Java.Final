package com.sensefilms.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
	
	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> collection) 
	{
	    List<T> typedList = new ArrayList<T>(collection.size());
	    
	    for(Object o : collection)
	    {
	    	typedList.add(tryCastAs(clazz, o));
	    }
	    
	    return typedList;
	}
}
