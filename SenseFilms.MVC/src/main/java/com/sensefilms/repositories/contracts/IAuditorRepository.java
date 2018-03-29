package com.sensefilms.repositories.contracts;

import com.sensefilms.business.entities.AuditEvent;

public interface IAuditorRepository 
{
	void insertNewEvent(AuditEvent event);
}
