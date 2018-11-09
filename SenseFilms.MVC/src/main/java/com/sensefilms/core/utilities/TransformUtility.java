package com.sensefilms.core.utilities;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class TransformUtility implements ITransformUtility
{
	private static ModelMapper _mapper;
	
	private static ModelMapper getInstance() 
	{
		if(_mapper == null) 
		{
			_mapper = new ModelMapper();
		}
		return _mapper;
	}
	
	public <TSource, TDestination> TDestination transform(TSource source, Class<TDestination> typeClass) 
	{
		return getInstance().map(source, typeClass);
	}
	
	public <TSource, TDestination> List<TDestination> transform(List<TSource> source, Class<TDestination> typeClass)
	{
		return source.stream()
				.map(item -> transform(item, typeClass))
				.collect(Collectors.toList());
	}
	
	public <TSource, TDestination> void setUpMapping(PropertyMap<TSource, TDestination> mapping) 
	{
		getInstance().addMappings(mapping);
	}
	
	public void registerDefinedMappings() 
	{
		// Register mappings here
	}
}
