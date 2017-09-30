package sensefilms.logic;

import java.sql.SQLException;
import sensefilms.entities.User;
import sensefilms.exceptions.LoggedException;
import sensefilms.interfaces.ILoginLogic;
import sensefilms.interfaces.IUserRepository;
import sensefilms.repositories.UserRepository;

public class LoginLogic implements ILoginLogic 
{
	private IUserRepository _userRepository;
	
	@Override
	public boolean isValidLogin(User user) throws LoggedException
	{
		_userRepository = new UserRepository();
		try 
		{
			User dbUser = _userRepository.getOneByUsername(user.getUsername());
			return (dbUser.getUsername().equals(user.getUsername()) && 
					dbUser.getPassword().equals(user.getPassword())); 
		}
		catch(SQLException sqlex) 
		{
			throw new LoggedException(sqlex, "An error ocurred during the login process");
		}
		catch(Exception ex) 
		{
			throw new LoggedException(ex, "An error ocurred during the login process");
		}
	}
}
