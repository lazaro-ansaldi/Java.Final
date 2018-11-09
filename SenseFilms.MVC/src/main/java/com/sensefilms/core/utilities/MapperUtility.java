package com.sensefilms.core.utilities;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class MapperUtility implements IMapperUtility
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
	
	public <TDestination> TDestination Map(Object source, Class<TDestination> typeClass) 
	{
		return getInstance().map(source, typeClass);
	}
	
	public <TSource, TDestination> void setUpMapping(PropertyMap<TSource, TDestination> mapping) 
	{
		getInstance().addMappings(mapping);
	}
}
