package com.sensefilms.business.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.sensefilms.business.entities.base.BasePersonData;
import com.sensefilms.business.enums.ClientType;

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
