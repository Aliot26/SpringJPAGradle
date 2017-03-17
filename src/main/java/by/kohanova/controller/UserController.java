package by.kohanova.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import by.kohanova.model.Users;
import by.kohanova.service.UsersService;

import java.util.List;

/**
 * Controller is used for processing
 * requests and return responses
 * to DispatcherServlet
 */
@RestController
public class UserController {

	@Autowired
	private UsersService userService;

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
	public List<Users> getUsers() {
		LOGGER.info("Start getUsers method");
		List<Users> listOfUsers = userService.findAll();			
		return listOfUsers;
	}
	
	/**
	 * Is used for getting user by name
	 * @param name - user name
	 * @return {@link Users} object
	 */
	@RequestMapping("/users/{name}")
	public Users getByName(@PathVariable String name) {
		LOGGER.info("Load user by name: {}", name);	
		return userService.find(name);
	}

}
