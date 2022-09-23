package ma.poc.services;

import ma.poc.models.UserDTO;

public interface IUserServices {

	UserDTO getUser(String id); 
	
	UserDTO insertUser(UserDTO user);
	
	UserDTO updateUser(String id, UserDTO user);
	
}
