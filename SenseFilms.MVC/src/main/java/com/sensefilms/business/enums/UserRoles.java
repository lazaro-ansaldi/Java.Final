package com.sensefilms.business.enums;

import java.util.HashMap;

public enum UserRoles 
{
	Administrator(0),
	User(1);
	
	private int value;
	private static HashMap<Integer, UserRoles> map = new HashMap<Integer, UserRoles>();
	
	private UserRoles(int value) 
	{
		this.value=value;
	}
	
    static 
    {
        for (UserRoles userRole : UserRoles.values()) 
        {
            map.put(userRole.value, userRole);
        }
    }
    
    public static UserRoles valueOf(int userRole) 
    {
        return map.get(userRole);
    }
	
	public int getValue()
	{
		return this.value;
	}

}
