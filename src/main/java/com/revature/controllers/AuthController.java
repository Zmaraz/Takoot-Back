package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private UserService uService;
	
	@Autowired
	public AuthController(UserService userService) {
		uService = userService;
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserByCredentials(@RequestBody User credentials) {
		
		String username = credentials.getUsername();
		String password = credentials.getPassword();
	
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.se
		List<User> users = uService.getUserByCredentials(username, password);
		
		Optional<User> user = users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
		if(user.isPresent()){
			
			
			return user.get();
			}
		else throw new UserNotFoundException("No user: " + username + "found with provided credentials.");
	}
}
