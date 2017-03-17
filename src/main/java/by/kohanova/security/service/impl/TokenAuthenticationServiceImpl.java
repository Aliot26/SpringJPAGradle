package by.kohanova.security.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import by.kohanova.model.AuthUser;
import by.kohanova.model.User;
import by.kohanova.security.service.TokenAuthenticationService;
import by.kohanova.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class TokenAuthenticationServiceImpl implements TokenAuthenticationService{

    @Value("security.token.secret.key")
    private String secretKey;

    private final static String HEADER_SECURITY_TOKEN = "h-token";

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(HttpServletRequest request) {
        String token = request.getHeader(HEADER_SECURITY_TOKEN);
        if (token != null) {
            final Jws<Claims> tokenData = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            User user = getUserFromToken(tokenData);
            if (user != null) {
                return new AuthUser(user);
            }
        }
        return null;
    }

    private User getUserFromToken(Jws<Claims> tokenData) {
        try {
            return userService.find(tokenData.getBody().get("login").toString());
        } catch (UsernameNotFoundException e) {
            return null;
        }
    }
}
