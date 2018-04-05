package com.sensefilms.business.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.sensefilms.business.enums.UserRoles;

@Entity
@Table(name = "web_menu_subitem")
public class WebMenuSubItem extends WebItem
{
	
}
