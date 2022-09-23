package ma.poc.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "id", "userName", "password", "lastName" , "firstName"})
public class UserDTO {

	@Schema(required = false)
	private String id;
	
	@Schema(required = true)
	private String userName;

	@Schema(required = true)
	private String password;

	@Schema(required = false)
	private String lastName;

	@Schema(required = false)
	private String firstName;
	
	
}
