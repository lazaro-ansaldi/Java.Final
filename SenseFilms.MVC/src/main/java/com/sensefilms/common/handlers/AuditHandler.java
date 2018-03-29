package com.sensefilms.common.handlers;

import com.sensefilms.business.entities.AuditEvent;

public class AuditHandler implements IAuditHandler
{

	@Override
	public void handleNewAuditEvent(String event, String description, String comments) 
	{
		AuditEvent auditEvent = new AuditEvent(description, event, comments);
		
	}

}
