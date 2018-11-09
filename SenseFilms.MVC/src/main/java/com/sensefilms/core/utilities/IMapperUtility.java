package com.sensefilms.core.utilities;

import org.modelmapper.PropertyMap;

public interface IMapperUtility 
{
	<TDestination> TDestination Map(Object source, Class<TDestination> typeClass);
	
	<TSource, TDestination> void setUpMapping(PropertyMap<TSource, TDestination> mapping); 
}
