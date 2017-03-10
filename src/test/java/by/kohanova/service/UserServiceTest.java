package by.kohanova.service;

import static org.junit.Assert.*;

import org.junit.Test;

import by.kohanova.controller.UserController;

public class UserServiceTest {

	@Test
	public void test() {
		System.out.println("Not yet implemented");
		String hello = "Hello Spring! It was written by Olga";
		UserController userController = new UserController();
		assertSame(hello, userController.hello()); 
	}

}
