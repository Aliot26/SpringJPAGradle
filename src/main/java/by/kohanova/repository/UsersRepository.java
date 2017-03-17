package by.kohanova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import by.kohanova.model.Users;

/**
 * Abstract repository wrapper to communicate with database
 */
public interface UsersRepository extends JpaRepository<Users, Integer> {

	/**
	 * Method to find user from database by user name
	 * 
	 * @param name - user name
	 * @return User entity
	 */
	@Query("select u from User u where u.name = :username")
	Users find(@Param("username") String name);
}
