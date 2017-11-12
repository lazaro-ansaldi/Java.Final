package sensefilms.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDbFactory 
{	
	public Connection getConn() throws SQLException;
	
	public void releaseConn() throws SQLException;

}
