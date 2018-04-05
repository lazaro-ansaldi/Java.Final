package com.sensefilms.business.entities;

import java.util.ArrayList;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sensefilms.business.enums.UserRoles;

@Entity
@Table(name = "web_menu_item")
public class WebMenuItem extends WebItem
{	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "subItemID")
	private ArrayList<WebMenuSubItem> subItemsCollection = new ArrayList<WebMenuSubItem>(0);
}
