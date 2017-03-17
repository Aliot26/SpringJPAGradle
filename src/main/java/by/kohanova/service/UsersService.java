package by.kohanova.service;

import java.util.List;

import by.kohanova.model.Users;

public interface UsersService {
	/**
	 * Method to return list of all users
	 * 
	 * @return list of users
	 */
	List<Users> findAll();

	/**
	 * Method to return user by user name
	 * 
	 * @param name
	 * @return user entity
	 */
	Users find(String name);
}
