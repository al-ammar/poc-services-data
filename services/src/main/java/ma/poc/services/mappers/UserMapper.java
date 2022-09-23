package ma.poc.services.mappers;

import ma.poc.models.UserDTO;
import ma.poc.persistence.entity.User;

public final class UserMapper {

	
	
	public static UserDTO toUserDTO(User user) {
		UserDTO dto = UserDTO.builder().password(user.getThePassword()).userName(user.getUserName()).build();
		dto.setId(user.getId());
		return dto;
	}

	public static User toUser(UserDTO dto) {
		User user = User.builder().thePassword(dto.getPassword()).userName(dto.getUserName()).build();
		user.setId(dto.getId());
		return user;
	}
	
	public static User mapUserDTO(UserDTO dto, User u) {
		u.setThePassword(dto.getPassword());
		u.setUserName(dto.getUserName());
		return u;
	}
}
