package com.sensefilms.repositories.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sensefilms.repositories.base.BaseRepository;
import com.sensefilms.repositories.contracts.IAuditorRepository;
import com.sensefilms.repositories.entities.AuditEvent;;

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
