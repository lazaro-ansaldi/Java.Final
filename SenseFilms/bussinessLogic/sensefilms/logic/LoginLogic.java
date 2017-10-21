package sensefilms.logic;

import java.sql.SQLException;
import java.util.Date;

import sensefilms.entities.User;
import sensefilms.exceptions.LoggedException;
import sensefilms.interfaces.ILoginLogic;
import sensefilms.interfaces.IUserRepository;
import sensefilms.repositories.UserRepository;

public class LoginLogic implements ILoginLogic 
{
	public LoginLogic() 
	{
		this._userRepository= new UserRepository();;
	}
	
	private IUserRepository _userRepository;
	
	@Override
	public boolean isValidLogin(User user) throws LoggedException
	{
		try 
		{
			User dbUser = _userRepository.getOneByUsername(user.getUsername());
			
			if(dbUser!=null && dbUser.getUsername().equals(user.getUsername()) && 
					dbUser.getPassword().equals(user.getPassword())) 
			{
				dbUser.setLastLogin(new Date());
				_userRepository.update(dbUser);
				return true;
			}
			
			return false;
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
