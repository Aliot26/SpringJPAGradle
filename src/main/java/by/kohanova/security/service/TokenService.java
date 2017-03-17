package by.kohanova.security.service;

public interface TokenService {
	String generateToken(String login, String password);
}
