package by.kohanova.security.service;

public interface TokenService {
	String generateToken(String username, String password);
}
