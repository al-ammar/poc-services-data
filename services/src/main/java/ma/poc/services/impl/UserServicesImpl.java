package ma.poc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ma.poc.models.UserDTO;
import ma.poc.persistence.entity.User;
import ma.poc.persistence.repository.UserRepository;
import ma.poc.services.IUserServices;
import ma.poc.services.mappers.UserMapper;

@Component
@Transactional
public class UserServicesImpl implements IUserServices {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDTO getUser(String id) {
		User user = repository.findById(id).get();
		return UserMapper.toUserDTO(user);
	}

	@Override
	public UserDTO insertUser(UserDTO user) {
		return UserMapper.toUserDTO((User) repository.save(UserMapper.toUser(user)));
	}

	@Override
	public UserDTO updateUser(String id, UserDTO user) {
		User u = repository.findById(id).get();
		if (u != null) {
			UserMapper.toUserDTO(repository.save(UserMapper.mapUserDTO(user, u)));
		}
		return user;
	}
}
