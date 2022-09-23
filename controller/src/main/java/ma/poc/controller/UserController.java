package ma.poc.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.poc.models.UserDTO;
import ma.poc.services.IUserServices;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "user services", description = "Prouf of concept Services ")
public class UserController {

	private final static String JSON_TYPE = MediaType.APPLICATION_JSON_VALUE;

	@Autowired
	private IUserServices services;

	@Operation(summary = "GET USER")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully retrieved a customer"),
			@ApiResponse(responseCode = "401", description = "Authorization denied"),
			@ApiResponse(responseCode = "404", description = "Not Found"),
			@ApiResponse(responseCode = "500", description = "Unexpected system exception") })
	@GetMapping(value = "/{userID}")
	public ResponseEntity<UserDTO> getUser(@PathVariable String userID) {
		return ResponseEntity.ok(services.getUser(userID));
	}

	@Operation(summary = "CREATE USER")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created a customer"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "401", description = "Authorization denied"),
			@ApiResponse(responseCode = "500", description = "Unexpected system exception"),
			@ApiResponse(responseCode = "502", description = "An error has occurred with an upstream service") })
	@PostMapping(consumes = JSON_TYPE)
	public ResponseEntity createUser(@Valid @RequestBody UserDTO user, UriComponentsBuilder uriBuilder) {
		UserDTO userCreated = services.insertUser(user);
		URI location = uriBuilder.path("/users/{userId}").buildAndExpand(userCreated.getId()).toUri();
		return ResponseEntity.created(location).contentType(MediaType.valueOf(JSON_TYPE)).body(userCreated);
	}

	@Operation(summary = "Update user")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Successfully updated a customer"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "401", description = "Authorization denied"),
			@ApiResponse(responseCode = "500", description = "Unexpected system exception"),
			@ApiResponse(responseCode = "502", description = "An error has occurred with an upstream service") })
	@PutMapping(value = "{id}", consumes = JSON_TYPE)
	public ResponseEntity updateUser(@PathVariable String id, @Valid @RequestBody UserDTO dto) {
		services.updateUser(id, dto);
		return ResponseEntity.noContent().build();
	}

}
