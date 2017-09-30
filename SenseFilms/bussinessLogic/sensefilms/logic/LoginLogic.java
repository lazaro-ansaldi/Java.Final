package sensefilms.logic;

import sensefilms.entities.User;
import sensefilms.interfaces.ILoginLogic;
import sensefilms.interfaces.IUserRepository;
import sensefilms.repositories.UserRepository;

public class LoginLogic implements ILoginLogic 
{
	private IUserRepository _userRepository;
	
	@Override
	public boolean isValidLogin(User user) throws Exception
	{
		_userRepository = new UserRepository();
		try 
		{
			User dbUser = _userRepository.getOneByUsername(user.getUsername());
			return (dbUser.getUsername().equals(user.getUsername()) && 
					dbUser.getPassword().equals(user.getPassword())); 
		}
		catch(Exception ex) 
		{
			throw ex;
		}
	}
}
