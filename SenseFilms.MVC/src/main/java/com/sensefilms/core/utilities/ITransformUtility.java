package com.sensefilms.core.utilities;

import java.util.List;

import org.modelmapper.PropertyMap;

public interface ITransformUtility 
{
	<TSource, TDestination> TDestination transform(TSource source, Class<TDestination> typeClass);
	
	<TSource, TDestination> List<TDestination> transform(List<TSource> source, Class<TDestination> typeClass);
	
	void registerDefinedMappings();
	
	<TSource, TDestination> void setUpMapping(PropertyMap<TSource, TDestination> mapping);
}
