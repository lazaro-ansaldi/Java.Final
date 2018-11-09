package com.sensefilms.core.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sensefilms.repositories.contracts.IAuditorRepository;
import com.sensefilms.repositories.entities.AuditEvent;

@Component
public class AuditUtility implements IAuditUtility
{

	IAuditorRepository _repository;
	
	@Autowired
	public AuditUtility(IAuditorRepository repository)
	{
		this._repository = repository;
	}
	
	@Override
	public void handleNewAuditEvent(String event, String description, String comments) 
	{
		AuditEvent auditEvent = new AuditEvent(description, event, comments);
		this._repository.insertNewEvent(auditEvent);
	}

}
