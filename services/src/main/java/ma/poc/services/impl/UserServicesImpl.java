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
		Page<User> results = repository.findAll(pageable);
		List<UserDTO> resultsDTO = results.stream().map(
				r -> UserDTO.builder().id(r.getId()).userName(r.getUserName()).password(r.getThePassword()).build())
				.collect(Collectors.toList());
		return new PageImpl<>(resultsDTO, pageable, results.getTotalElements());
	}
}
