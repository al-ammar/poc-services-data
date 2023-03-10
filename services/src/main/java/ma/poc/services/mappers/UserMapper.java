package ma.poc.services.mappers;

import ma.poc.models.UserDTO;
import ma.poc.persistence.entity.User;

public final class UserMapper {

	public static UserDTO toUserDTO(User user) {
		return UserDTO.builder().password(user.getThePassword()).userName(user.getUserName())
				.creationDate(user.getInsertedAt()).id(user.getId()).lastName(user.getLastName()).updateDate(user.getUpdateDate())
				.firstName(user.getFirstName()).content(user.getContent()).build();

	}

	public static User toUser(UserDTO dto) {
		User user = User.builder().thePassword(dto.getPassword()).userName(dto.getUserName())
				.updateDate(dto.getUpdateDate()).lastName(dto.getLastName()).firstName(dto.getFirstName()).build();
		user.setId(dto.getId());
		user.setInsertedAt(dto.getCreationDate());
		return user;
	}

	public static User mapUserDTO(UserDTO dto, User u) {
		u.setThePassword(dto.getPassword());
		u.setUserName(dto.getUserName());
		u.setUpdateDate(dto.getUpdateDate());
		u.setLastName(dto.getLastName());
		u.setFirstName(dto.getFirstName());
		return u;
	}
}
