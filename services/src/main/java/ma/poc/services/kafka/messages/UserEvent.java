package ma.poc.services.kafka.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.poc.models.UserDTO;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEvent extends BuisnessEvent{

	private UserDTO dto;
}
