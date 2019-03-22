package com.revature.services;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.models.User;

public class UserService {
	
	private UserDAO userDao = new UserDAO();
	
	// get all users
	public List<User> getAllUsers() {
		
		System.out.println("In getAllUsers() inside UserService");
		return userDao.getAll();
		
	}
	
	
	// Get user by Id
	public List<User> getUserById (int id) {
		
		System.out.println("In getUserById() inside UserService");
		if (id > 0)
			return userDao.getById(id);
		
		return null;
		
	}
	
	
	// add a new user if fields arent blank
	public User addUser(User newUser) {
		
		System.out.println("In addUser() inside UserService");
		User oldUser = new User();
		
		String oldUsername = oldUser.getUsername();

		if (newUser.getUsername().equals("") || 
				newUser.getPassword().equals("") || 
				newUser.getFirst_name().equals("") || 
				newUser.getLast_name().equals("") ||
				newUser.getEmail().equals("")) {
			return null;
		}
		
		if(newUser.getUsername().equals(userDao.getByUsername(oldUsername))) {
			return null;
		}
		
		return userDao.add(newUser);
		
	}
		
	
	// update a user
	public User updateUser(User updatedUser) {
		
		System.out.println("In updateUser() inside UserService");
		return userDao.update(updatedUser);
		
	}
	
	
	// delete a user
	public boolean deleteUser (int id) {
		
		System.out.println("In deleteUser() inside UserService");
		return userDao.delete(id);
		
	}
	
	
	// get user by their credentials (username/password)
	public List<User> getUserByCredentials(String username, String password) {
		
		System.out.println("In getUserByCredentials() inside UserService");
		if (!username.equals("") && !password.equals("")) 
			return userDao.getByCredentials(username, password);
		
		return null;
		
	}
	
	
	// get a user by their username
	public List<User> getUserByUsername(String username) {
		
		System.out.println("In getUserByUsername() inside UserService");
		if (!username.equals("")) 
			return userDao.getByUsername(username);
			
		return null;
		
	}
	
	
}
