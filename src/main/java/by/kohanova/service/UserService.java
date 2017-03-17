package by.kohanova.service;

import java.util.List;

import by.kohanova.model.User;

/**
 * Service for {@link User}
 */
public interface UserService {
	/**
	 * Method to return user by user login
	 * 
	 * @param login
	 * @return user entity
	 */
	User find(String login);
	
	/**
	 * Method to return list of all users
	 * 
	 * @return list of users
	 */
	List<User> findAll();
}
