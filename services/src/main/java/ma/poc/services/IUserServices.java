package ma.poc.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ma.poc.models.UserDTO;

public interface IUserServices {

	UserDTO getUser(String id); 
	
	UserDTO insertUser(UserDTO user);
	
	UserDTO updateUser(String id, UserDTO user);
	
	void deleteUser(String id);
	
	Page<UserDTO> getUsers(Pageable pageable);
	
}
