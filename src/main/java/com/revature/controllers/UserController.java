package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.UserNotFoundException;
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
	public List<User> getAllUsers(){
		return uService.getAllUsers();
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@PathVariable int Id) {
		List<User> users = uService.getUserById(Id);
		Optional<User> user = users.stream().filter(u -> u.getUser_id() == Id).findFirst();
		if(user.isPresent())return user.get();
		else throw new UserNotFoundException("No flash card with id " + Id + " found");
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
	
	
}
