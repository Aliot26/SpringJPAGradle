package by.kohanova.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import by.kohanova.model.User;
import by.kohanova.service.UserService;

import java.util.List;

/**
 * Controller is used for processing
 * requests and return responses
 * to DispatcherServlet
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	/**
	 * Is used for defining incoming request url with part "/hello"
	 * @return greeting string
	 */
	@RequestMapping("/hello")
	public String hello() {
		LOGGER.info("Start hello method");
		String hello = "Hello Spring! It was written by Olga";
		return hello;
	}
	
	/**
	 * Is used for getting list of users
	 * @return list of users
	 */
	@RequestMapping("/users")
	public List<User> getUsers() {
		LOGGER.info("Start getUsers method");
		List<User> listOfUsers = userService.findAll();			
		return listOfUsers;
	}
	
	/**
	 * Is used for getting user by name
	 * @param name - user name
	 * @return {@link User} object
	 */
	@RequestMapping("/users/{name}")
	public User getByName(@PathVariable String name) {
		LOGGER.info("Load user by name: {}", name);	
		return userService.find(name);
	}

}
