package sensefilms.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sensefilms.connection.DbFactory;
import sensefilms.entities.User;
import sensefilms.enums.UserRoles;
import sensefilms.exceptions.LoggedException;
import sensefilms.helpers.DateTimeHelper;
import sensefilms.interfaces.IUserRepository;

public class UserRepository implements IUserRepository 
{

	private String query;
	private PreparedStatement stmt=null;
	
	@Override
	public void insert(User entity) throws SQLException 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getOneById(int id) throws SQLException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User entity) throws SQLException, LoggedException 
	{
		query = "UPDATE Users SET Username=?, Password=?, Name=?, LastName=?, LastLogin=?, RoleID=? WHERE UserID=?";
		try 
		{
			stmt = DbFactory.getInstancia().getConn().prepareStatement(query);
			stmt.setString(1, entity.getUsername());
			stmt.setString(2, entity.getPassword());
			stmt.setString(3, entity.getName());
			stmt.setString(4, entity.getLastName());
			stmt.setDate(5, DateTimeHelper.ParseToSqlDate(entity.getLastLogin()));
			stmt.setInt(6, entity.getUserRole().getValue());
			stmt.setInt(7, entity.getId());
			
			stmt.executeUpdate();
		}
		catch(LoggedException loggex) 
		{
			throw loggex;
		}
		catch(SQLException sqlex) 
		{
			throw sqlex;
		}
		finally 
		{
			try 
			{
				DbFactory.getInstancia().releaseConn();
			}
			catch(Exception ex) 
			{
				
			}			
			if(stmt!=null) stmt.close();
		}
	}

	@Override
	public void deleteOneById(int id) throws SQLException
	{		
	}

	@Override
	public User getOneByUsername(String username) throws SQLException, LoggedException
	{		
		query = "SELECT * FROM Users WHERE Username=?";
		ResultSet rs = null;
		User currentUser=null;
		try 
		{
			stmt = DbFactory.getInstancia().getConn().prepareStatement(query);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if(rs.next()) 
			{
				currentUser = new User();
				currentUser.setId(rs.getInt("UserID"));
				currentUser.setName(rs.getString("Name"));
				currentUser.setPassword(rs.getString("Password"));
				currentUser.setUsername(rs.getString("Username"));
				currentUser.setUserRole(UserRoles.valueOf(rs.getInt("RoleID")));
				currentUser.setLastLogin(rs.getTimestamp("LastLogin"));
				currentUser.setLastName(rs.getString("LastName"));
			}
		}
		catch(LoggedException loggex)
		{
			throw loggex;
		}
		catch(SQLException sqlex)
		{
			
		}
		finally
		{
			try 
			{
				DbFactory.getInstancia().releaseConn();
			}
			catch(Exception ex) 
			{
				
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		return currentUser;
	}

}
