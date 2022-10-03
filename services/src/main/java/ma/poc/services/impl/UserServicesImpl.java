package ma.poc.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import ma.poc.models.UserCriteriaDTO;
import ma.poc.models.UserDTO;
import ma.poc.persistence.entity.User;
import ma.poc.persistence.repository.UserRepository;
import ma.poc.services.IUserServices;
import ma.poc.services.mappers.UserMapper;

@Slf4j
@Component
@Transactional
public class UserServicesImpl implements IUserServices {

	private UserRepository repository;

	@Autowired
	public UserServicesImpl(UserRepository repository) {
		this.repository = repository;
	}

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
	public UserDTO insertUser(UserDTO user, byte[] piece) {
		User userDB = UserMapper.toUser(user);
		userDB.setContent(piece);
		return UserMapper.toUserDTO((User) repository.save(userDB));
	}

	@Override
	public UserDTO updateUser(String id, UserDTO user) {
		try {
			User u = repository.findById(id).get();
			if (u != null) {
				UserMapper.toUserDTO(repository.save(UserMapper.mapUserDTO(user, u)));
			}
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void deleteUser(String id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
		}
	}

	@Override
	public Page<UserDTO> getUsers(Pageable pageable) {
		try {
			Page<User> results = repository.findAll(pageable);
			List<UserDTO> resultsDTO = results.stream().map(UserMapper::toUserDTO).collect(Collectors.toList());
			return new PageImpl<>(resultsDTO, pageable, results.getTotalElements());
		} catch (Exception e) {
			log.error("Error getUsers Pageable", e);
			return null;
		}
	}

	@Override
	public List<UserDTO> searchUsers(UserCriteriaDTO user) {
		return repository.searchByCritteria(user).stream().map(UserMapper::toUserDTO)
				.collect(Collectors.toList());
	}
}
