package ma.poc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.poc.models.UserDTO;
import ma.poc.persistence.entity.User;
import ma.poc.persistence.repository.UserRepository;

@RequestMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class LoginController {

	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public ResponseEntity<Map> getUsers(Pageable pageable) {
		List<User> users = new ArrayList<>();
		for (int i = 0; i < 2000; i++) {
			User user = new User();
			user.setFirstName(UUID.randomUUID().toString());
			user.setLastName(UUID.randomUUID().toString());
			user.setUserName(UUID.randomUUID().toString());
			user.setThePassword(UUID.randomUUID().toString());
			users.add(user);
		}
		repository.saveAll(users);
		return ResponseEntity.noContent().build();
	}

	
	@CrossOrigin
	@PostMapping()
	public ResponseEntity login(@Valid @RequestBody UserDTO dto) {
		dto.setAuthenticated(true);
		return ResponseEntity.ok().body(dto);

	}

}
