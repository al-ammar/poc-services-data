package ma.poc.persistence.repository;

import java.util.List;

import ma.poc.models.UserCriteriaDTO;
import ma.poc.persistence.entity.User;

public interface UserRepositoryCustom {
	List<User> searchByCritteria(UserCriteriaDTO user);
}
