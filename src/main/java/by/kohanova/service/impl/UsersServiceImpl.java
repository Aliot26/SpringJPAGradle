package by.kohanova.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kohanova.model.Users;
import by.kohanova.repository.UsersRepository;
import by.kohanova.service.UsersService;

/**
 * UserService interface implementation
 */
@Service()
public class UsersServiceImpl implements UsersService {

	/**
	 * Injects UserRepository bean
	 */
	@Autowired
	private final UsersRepository userRepository;

	/**
	 * Constructor for UserRepository setting
	 * @param userRepository
	 */
	public UsersServiceImpl(UsersRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Users find(String name) {
		return userRepository.find(name);
	}
}