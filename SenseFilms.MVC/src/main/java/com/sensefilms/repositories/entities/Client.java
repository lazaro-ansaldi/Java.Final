package com.sensefilms.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.sensefilms.core.enums.ClientType;
import com.sensefilms.repositories.entities.base.BasePersonData;

@Entity
@Table(name = "client")
public class Client extends BasePersonData
{
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ClientType", nullable = false)
	private ClientType clientType;

	public ClientType getClientType()
	{
		return clientType;
	}

	public void setClientType(ClientType clientType)
	{
		this.clientType = clientType;
	}
}
