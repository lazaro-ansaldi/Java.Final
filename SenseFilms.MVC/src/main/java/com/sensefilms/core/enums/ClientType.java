package com.sensefilms.core.enums;

import java.util.HashMap;

public enum ClientType
{
	Individual(0),
	Company(1);
	
	private int value;
	private static HashMap<Integer, ClientType> map = new HashMap<Integer, ClientType>();
	
	private ClientType(int value) 
	{
		this.value=value;
	}
	
    static 
    {
        for (ClientType clientType : ClientType.values()) 
        {
            map.put(clientType.value, clientType);
        }
    }
    
    public static ClientType valueOf(int clientType) 
    {
        return map.get(clientType);
    }
	
	public int getValue()
	{
		return this.value;
	}
}
