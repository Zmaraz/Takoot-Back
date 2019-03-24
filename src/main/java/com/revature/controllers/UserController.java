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

import com.revature.exceptions.UserErrorResponse;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Principal;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService uService;
	
	@Autowired
	public UserController(UserService userService) {
		uService = userService;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers(@RequestAttribute("principal") Principal principal){
		System.out.println("Principal in user controller: " + principal); //able to get principal object from request header.
		
		List<User> responseUser = new ArrayList<>();
		List<User> allUsers = uService.getAllUsers();
		for(User u : allUsers) {
			User user = new User();
			user.setFirst_name(u.getFirst_name());
			user.setLast_name(u.getLast_name());
			user.setUsername(u.getUsername());
			user.setPassword(u.getPassword());
			user.setEmail(u.getEmail());
			
			responseUser.add(user);
		}
		return responseUser;
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)

	public User getUserById(@PathVariable int id, @RequestAttribute("principal") Principal principal) {
		

		List<User> users = uService.getUserById(id);
		Optional<User> user = users.stream().filter(u -> u.getUser_id() == id).findFirst();
		if(user.isPresent()){
			System.out.println(user);
			return user.get();
			}
		else throw new UserNotFoundException("No user with id: " + id + " found");
	}
	
	@GetMapping(value="/uname/{username}", produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserByUsername(@PathVariable String username) {
		List<User> users = uService.getUserByUsername(username);
		Optional<User> user = users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
		if(user.isPresent()){
			System.out.println(user);
			return user.get();
			}
		else throw new UserNotFoundException("No username: " + username + " found");
	}
	
	@PostMapping(value="/creds", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserByCredentials(@RequestBody User credentials) {
		
		String username = credentials.getUsername();
		String password = credentials.getPassword();
	
		List<User> users = uService.getUserByCredentials(username, password);
		
		Optional<User> user = users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
		if(user.isPresent()){
			return user.get();
			}
		else throw new UserNotFoundException("No user: " + username + "found with provided credentials.");
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User newUser) {
		return uService.addUser(newUser);
	}
	
	@PatchMapping(consumes="application/json", produces="application/json")
	public ResponseEntity<User> updateUser(@RequestBody User updatedUser){
		User newUser = uService.updateUser(updatedUser);
		
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
