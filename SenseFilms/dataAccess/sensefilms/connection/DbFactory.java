package sensefilms.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import sensefilms.exceptions.LoggedException;
import sensefilms.utils.ConfigHandler;

import java.sql.Connection;

public class DbFactory {

	private String dbDriver;
	private String host;
	private String port;
	private String user;
	private String pass;
	private String db;
	private String dbType;
	
	private Connection conn;
	private int cantConn=0;
	
	private DbFactory() throws LoggedException
	{
		try 
		{
			initData();
			Class.forName(dbDriver);
		} 
		catch (ClassNotFoundException cnfex) 
		{		
			throw new LoggedException(cnfex, dbDriver + " cannot be found");
		}
		catch (Exception ex) 
		{
			throw new LoggedException(ex, "Error while trying to load the driver.");
		}
	}
	
	private static DbFactory instancia;
	
	public static DbFactory getInstancia() throws LoggedException
	{
		if (instancia==null)
		{
			instancia = new DbFactory();
		}
		return instancia;
	}
	
	public Connection getConn() throws SQLException
	{
		try 
		{
			if(conn==null || conn.isClosed())
			{
				conn = DriverManager.getConnection("jdbc:"+dbType+"://"+host
						+":"+port+"/"+db+"?user="+user+"&password="+pass);
				cantConn++;
			}
		} 
		catch (SQLException sqlex) 
		{
			throw new SQLException("Error while trying to connect to database: " + db, sqlex);
		}
		return conn;
	}
	
	public void releaseConn() throws Exception
	{
		try 
		{
			cantConn--;
			if(cantConn==0)
			{
				conn.close();
			}
		} 
		catch (SQLException sqlex) 
		{
			throw new SQLException("Error al cerrar conexión",sqlex);
		}
	}
	
	//Retrieve connection data from properties file
	private void initData() throws LoggedException
	{
		try 
		{
			dbDriver=ConfigHandler.getPropertieValue("dbDriver");
			host=ConfigHandler.getPropertieValue("host");
			port=ConfigHandler.getPropertieValue("port");
			user=ConfigHandler.getPropertieValue("user");
			pass=ConfigHandler.getPropertieValue("pass");
			db=ConfigHandler.getPropertieValue("db");
			dbType=ConfigHandler.getPropertieValue("dbType");			
		}
		catch(Exception ex) 
		{
			throw new LoggedException(ex, "Error ocurred when try to read data from file");
		}	
	}
}
