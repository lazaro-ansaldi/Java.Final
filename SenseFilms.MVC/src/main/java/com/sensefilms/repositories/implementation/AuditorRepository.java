package com.sensefilms.repositories.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sensefilms.business.entities.AuditEvent;
import com.sensefilms.repositories.contracts.IAuditorRepository;;

@Repository
@Transactional
public class AuditorRepository extends BaseRepository implements IAuditorRepository
{

	@Override
	public void insertNewEvent(AuditEvent event) 
	{
		getSessionFactory().getCurrentSession().save(event);
	}

}
