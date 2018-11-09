package com.sensefilms.repositories.contracts;

import com.sensefilms.repositories.entities.AuditEvent;

public interface IAuditorRepository 
{
	void insertNewEvent(AuditEvent event);
}
