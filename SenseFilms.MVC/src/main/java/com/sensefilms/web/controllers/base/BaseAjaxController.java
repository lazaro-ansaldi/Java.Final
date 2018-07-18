package com.sensefilms.web.controllers.base;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sensefilms.common.utils.JsonSerializer;
import com.sensefilms.common.utils.StringUtils;

public abstract class BaseAjaxController extends BaseController
{
	public BaseAjaxController(Class<? extends BaseAjaxController> clazz)
	{
		super(clazz);
	}
	
	protected ResponseEntity<Object> handleException(String jsonBody) 
	{
		return new ResponseEntity<>(jsonBody, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	protected ResponseEntity<Object> statusOk(String jsonBody)
	{
		return new ResponseEntity<>(jsonBody, HttpStatus.OK);
	}
	
	protected ResponseEntity<Object> statusOk()
	{
		return statusOk(StringUtils.EMPTY);
	}
	
	protected String json(Object data) 
	{
		return JsonSerializer.serializeAsJson(data);
	}
	
	protected String json(ArrayList<Object> data) 
	{
		return JsonSerializer.serializeAsJson(data);
	}
}