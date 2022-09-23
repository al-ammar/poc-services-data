package ma.poc.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.poc.persistence.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
