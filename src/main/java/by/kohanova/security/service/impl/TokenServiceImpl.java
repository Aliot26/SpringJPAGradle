package by.kohanova.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import by.kohanova.security.service.TokenService;
import by.kohanova.service.PersonService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenServiceImpl implements TokenService {
	@Value("security.token.secret.key")
	private String tokenKey;

	@Autowired
	private PersonService personService;

	@Override
	public String generateToken(String username, String password) {
		if (username == null || password == null)
			return null;
		User user = personService.findByUsername(username);
		Map<String, Object> tokenData = new HashMap<>();
		if (password.equals(user.password)) {
			tokenData.put("clientType", "user");
			tokenData.put("userID", user.id);
			tokenData.put("username", user.username);
			tokenData.put("token_create_date", LocalDateTime.now());
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MINUTE, 60);
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
