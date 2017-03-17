package by.kohanova.security.service.impl;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import by.kohanova.model.User;
import by.kohanova.security.service.TokenService;
import by.kohanova.service.UserService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenServiceImpl implements TokenService {
	@Value("security.token.secret.key")
	private String tokenKey;

	@Autowired
	private UserService userService;

	@Override
	public String generateToken(String login, String password) {
		if (login == null || password == null)
			return null;
		User user = userService.find(login);
		Map<String, Object> tokenData = new HashMap<>();
		if (password.equals(user.password)) {
			tokenData.put("clientType", "user");			
			tokenData.put("username", user.login);
			tokenData.put("userpassword", user.password);
			tokenData.put("token_create_date", LocalDateTime.now());
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.YEAR, 100);
			tokenData.put("token_expiration_date", calendar.getTime());
			JwtBuilder jwtBuilder = Jwts.builder();
			jwtBuilder.setExpiration(calendar.getTime());
			jwtBuilder.setClaims(tokenData);
			return jwtBuilder.signWith(SignatureAlgorithm.HS512, tokenKey).compact();
		} else {
			System.out.println("ERROR");
			return null;
		}
	}
}
