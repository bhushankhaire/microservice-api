package spring.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	// @Query("SELECT p FROM User p WHERE p.emailId =?1")
	Optional<User> findByEmailId(String emailId);

}
