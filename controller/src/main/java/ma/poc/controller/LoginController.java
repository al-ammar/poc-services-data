package ma.poc.controller;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.poc.models.UserDTO;

@RequestMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class LoginController {

	@CrossOrigin
	@PostMapping()
	public ResponseEntity login(@Valid @RequestBody UserDTO dto) {
		dto.setAuthenticated(true);
		return ResponseEntity.ok().body(dto);

	}

}
