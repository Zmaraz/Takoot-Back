package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.UserErrorResponse;
import com.revature.exceptions.UserNotFoundException;
import com.revature.filters.jsonview.UserView;
import com.revature.models.Principal;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.util.JwtConfig;
import com.revature.util.JwtGenerator;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private UserService uService;
	
	@Autowired
	public AuthController(UserService userService) {
		uService = userService;
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public MappingJacksonValue getUserByCredentials(@RequestBody Principal credentials, HttpServletResponse resp) {
		
		System.out.println("in Auth Controller post method.");
		String username = credentials.getUsername();
		String password = credentials.getPassword();
	
		
		List<User> users = uService.getUserByCredentials(username, password);
		User responseUser = new User();
		
		Optional<User> user = users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
		if(user.isPresent()){
			
			resp.addHeader(JwtConfig.HEADER, JwtConfig.PREFIX + JwtGenerator.createJwt(user.get()));
			
			responseUser.setFirst_name(user.get().getFirst_name());
			
//			responseUser.setLast_name(user.get().getLast_name());
//			responseUser.setUsername(user.get().getUsername());
//			responseUser.setPassword(user.get().getPassword());
//			responseUser.setEmail(user.get().getEmail());
			
			MappingJacksonValue jacksonValue = new MappingJacksonValue(user.get());
			jacksonValue.setSerializationView(UserView.Private.class);
			return jacksonValue;
			}
		
		else throw new UserNotFoundException("No user: " + username + "found with provided credentials.");
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public UserErrorResponse handleException(UserNotFoundException e) {
		UserErrorResponse error = new UserErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return error;
	}
}
