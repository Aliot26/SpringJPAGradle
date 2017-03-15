package by.kohanova.security.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import by.kohanova.security.service.TokenAuthenticationService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class TokenAuthenticationServiceImpl implements TokenAuthenticationService{

    @Value("security.token.secret.key")
    private String secretKey;

    private final static String AUTH_HEADER_NAME = "x-auth-token";

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(HttpServletRequest request) {
        String token = request.getHeader(AUTH_HEADER_NAME);
        if (token != null) {
            final Jws<Claims> tokenData = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            User user = getUserFromToken(tokenData);
            if (user != null) {
                return new UserAuthentication(user);
            }
        }
        return null;
    }

    private User getUserFromToken(Jws<Claims> tokenData) {
        try {
            return userService.findByUsername(tokenData.getBody().get("username").toString());
        } catch (UsernameNotFoundException e) {
            return null;
        }
    }
}
