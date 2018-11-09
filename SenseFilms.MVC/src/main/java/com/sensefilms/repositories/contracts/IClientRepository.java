package com.sensefilms.repositories.contracts;

import com.sensefilms.repositories.base.IBaseCRUDRepository;
import com.sensefilms.repositories.entities.Client;

public interface IClientRepository extends IBaseCRUDRepository<Client>
{
	void deleteRange(int[] ids);
}
