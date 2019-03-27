package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.revature.ApplicationConfig;
import com.revature.exceptions.UserErrorResponse;
import com.revature.exceptions.UserNotFoundException;
import com.revature.filters.DepthFilter;
import com.revature.models.Principal;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService uService;
//	private ObjectMapper oMapper;
	
	@Autowired
	public UserController(UserService userService) {
		uService = userService;
	}
	
//	@Autowired
//	public void setUserController(ObjectMapper objectMapper) {
//		oMapper = objectMapper;
//	}
	
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers(@RequestAttribute("principal") Principal principal){
		System.out.println("Principal in user controller: " + principal); //able to get principal object from request header.
		ObjectMapper om = new ObjectMapper().registerModule(new Hibernate5Module());
		SimpleFilterProvider depthFilters = new SimpleFilterProvider().addFilter("depth_1", new DepthFilter(1))
	            .addFilter("depth_2", new DepthFilter(2))
	            .addFilter("depth_3", new DepthFilter(3))
	            .addFilter("depth_4", new DepthFilter(4))
	            .addFilter("depth_5", new DepthFilter(5));
		om.setFilterProvider(depthFilters);
		List<User> allUsers = uService.getAllUsers();
		for(User u : allUsers)u.setPassword("***");
		
		return allUsers;
	}
	
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@PathVariable int id, @RequestAttribute("principal") Principal principal) {
		
		if(principal.getId() != id) throw new UserNotFoundException("Unauthorized");
		
		List<User> users = uService.getUserById(id);
		Optional<User> user = users.stream().filter(u -> u.getUser_id() == id).findFirst();
		if(user.isPresent()){
			System.out.println(user);
			
			User responseUser = new User(user.get().getUser_id(), user.get().getFirst_name(), user.get().getLast_name(), user.get().getUsername(), "***", user.get().getEmail());
			
			return responseUser;
			
			}
		else throw new UserNotFoundException("No user with id: " + id + " found");
	}
	
	@GetMapping(value="/uname/{username}", produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserByUsername(@PathVariable String username, @RequestAttribute("principal") Principal principal ) {
		
		if(!principal.getUsername().equalsIgnoreCase(username)) throw new UserNotFoundException("Unauthorized");
		
		List<User> users = uService.getUserByUsername(username);
		Optional<User> user = users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
		if(user.isPresent()){
			System.out.println(user);
			
			User responseUser = new User(user.get().getUser_id(), user.get().getFirst_name(), user.get().getLast_name(), user.get().getUsername(), "***", user.get().getEmail());
			
			return responseUser;
			}
		else throw new UserNotFoundException("No username: " + username + " found");
	}
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User newUser) {
		User addedUser = uService.addUser(newUser);
		User responseUser = new User(addedUser.getUser_id(), addedUser.getFirst_name(), addedUser.getLast_name(), addedUser.getUsername(), "***", addedUser.getEmail());
		return responseUser;
	}
	
	@PatchMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<User> updateUser(@RequestBody User updatedUser, @RequestAttribute("principal") Principal principal){
		
		User newUser = uService.updateUser(updatedUser);
		
		if(newUser == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		else {
		
			User responseUser = new User(newUser.getUser_id(), newUser.getFirst_name(), newUser.getLast_name(), newUser.getUsername(), "***", newUser.getEmail());
		
			return new ResponseEntity<>(responseUser, HttpStatus.OK);
		}
	}
	
	@DeleteMapping(value="/{Id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable int Id) {
		uService.deleteUser(Id);
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
