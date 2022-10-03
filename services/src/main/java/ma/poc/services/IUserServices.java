package ma.poc.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ma.poc.models.UserCriteriaDTO;
import ma.poc.models.UserDTO;

public interface IUserServices {

	UserDTO getUser(String id); 
	
	UserDTO insertUser(UserDTO user);
	
	UserDTO insertUser(UserDTO user, byte[] piece);

	UserDTO updateUser(String id, UserDTO user);
	
	void deleteUser(String id);
	
	Page<UserDTO> getUsers(Pageable pageable);
	
	List<UserDTO> searchUsers(UserCriteriaDTO user);
	
}
