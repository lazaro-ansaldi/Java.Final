package com.sensefilms.core.utilities;

public interface IAuditUtility 
{
	void handleNewAuditEvent(String event, String description, String comments);
}
