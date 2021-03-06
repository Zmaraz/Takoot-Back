package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.revature.dtos.UserDTO;
import com.revature.exceptions.UserErrorResponse;
import com.revature.exceptions.UserNotFoundException;
import com.revature.filters.jsonview.UserView;
import com.revature.models.Principal;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.util.JwtConfig;
import com.revature.util.JwtGenerator;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService uService;

	
	@Autowired
	public UserController(UserService userService) {
		uService = userService;
	}
		
	
	@JsonView(UserView.Quiz.class)
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers(@RequestAttribute("principal") Principal principal){
		System.out.println("Principal in user controller: " + principal); //able to get principal object from request header.

		List<User> allUsers = uService.getAllUsers();
		for(User u : allUsers)u.setPassword("***");
		
		return allUsers;
	}
	
	@JsonView(UserView.Quiz.class)
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
	
	@JsonView(UserView.Quiz.class)
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
	
	@JsonView(UserView.Private.class)
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody UserDTO newUser, HttpServletResponse resp) {
		User addingUser = new User(0, newUser.getFirstName(), newUser.getLastName(), newUser.getUsername(), newUser.getPassword(), newUser.getEmail());
		System.out.println(addingUser);
		User addedUser = uService.addUser(addingUser);
		System.out.println(addedUser);
		resp.addHeader(JwtConfig.HEADER, JwtConfig.PREFIX + JwtGenerator.createJwt(addedUser));
		return addedUser;
	}
	
	@JsonView(UserView.Private.class)
	@PutMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<User> updateUser(@RequestBody UserDTO updatedUser, @RequestAttribute("principal") Principal principal){
		
		User updatingUser = new User(principal.getId(), updatedUser.getFirstName(), updatedUser.getLastName(), updatedUser.getUsername(), updatedUser.getPassword(), updatedUser.getEmail());
		User newUser = uService.updateUser(updatingUser);
		
		if(newUser == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		else return new ResponseEntity<>(newUser, HttpStatus.OK);
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
