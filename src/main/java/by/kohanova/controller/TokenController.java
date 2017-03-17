package by.kohanova.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import by.kohanova.model.Token;
import by.kohanova.model.User;
import by.kohanova.security.service.TokenService;

@RestController
@RequestMapping("/auth")
public class TokenController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenController.class);

    @Autowired
    private TokenService tokenService;
   
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody User user) {
        LOGGER.info("Start authentication");
        String token = tokenService.generateToken(user.login, user.password);
        if (token != null) {
            Token response = new Token();
            response.token = token;
            LOGGER.info("Authentication successful! Returning token");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            LOGGER.error("Token corrupted");
            return new ResponseEntity<>("Token corrupted", HttpStatus.BAD_REQUEST);
        }
    }
}
