package com.sensefilms.common.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sensefilms.business.entities.AuditEvent;
import com.sensefilms.repositories.contracts.IAuditorRepository;

@Component
public class AuditHandler implements IAuditHandler
{

	IAuditorRepository _repository;
	
	@Autowired
	public AuditHandler(IAuditorRepository repository)
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
