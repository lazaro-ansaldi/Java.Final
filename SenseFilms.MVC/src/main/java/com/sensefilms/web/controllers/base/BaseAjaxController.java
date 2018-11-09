package com.sensefilms.web.controllers.base;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sensefilms.core.extensions.StringExtensions;
import com.sensefilms.core.utilities.IAuthenticationContext;
import com.sensefilms.web.support.JsonSerializer;

public abstract class BaseAjaxController extends BaseController
{
	public BaseAjaxController(Class<? extends BaseAjaxController> clazz, IAuthenticationContext authenticationContext)
	{
		super(clazz, authenticationContext);
	}
	
	protected ResponseEntity<Object> handleException(String jsonBody) 
	{
		return new ResponseEntity<>(jsonBody, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	protected ResponseEntity<Object> statusOk(String jsonBody)
	{
		return new ResponseEntity<>(jsonBody, HttpStatus.OK);
	}
	
	protected ResponseEntity<Object> statusOk(Object body)
	{
		return new ResponseEntity<>(JsonSerializer.serializeAsJson(body), HttpStatus.OK);
	}
	
	protected ResponseEntity<Object> statusOk()
	{
		return statusOk(StringExtensions.EMPTY);
	}
	
	protected String jsonResult(Object data) 
	{
		return JsonSerializer.serializeAsJson(data);
	}
	
	protected String jsonResult(List<Object> data) 
	{
		return JsonSerializer.serializeAsJson(data);
	}
}
