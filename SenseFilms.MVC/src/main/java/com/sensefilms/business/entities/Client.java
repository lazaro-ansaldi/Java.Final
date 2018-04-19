package com.sensefilms.business.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sensefilms.business.entities.base.BasePersonData;

@Entity
@Table(name = "client")
public class Client extends BasePersonData
{
	
}
