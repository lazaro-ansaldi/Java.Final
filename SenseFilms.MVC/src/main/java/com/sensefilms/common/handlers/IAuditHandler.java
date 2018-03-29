package com.sensefilms.common.handlers;

public interface IAuditHandler 
{
	void handleNewAuditEvent(String event, String description, String comments);
}
