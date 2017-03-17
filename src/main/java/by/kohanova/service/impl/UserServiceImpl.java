package by.kohanova.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import by.kohanova.model.User;
import by.kohanova.repository.UserRepository;
import by.kohanova.service.UserService;

/**
 * Implementation of {@link UserService} service
 */
public class UserServiceImpl implements UserService{

	@Autowired
    private UserRepository userRepository;
	
	@Override
	public User find(String login) {
		return userRepository.find(login);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
