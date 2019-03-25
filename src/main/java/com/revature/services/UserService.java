package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dao.UserDAO;
import com.revature.models.User;

@Service
public class UserService {
	
	private UserDAO userDao = new UserDAO();
	
	// Get all users
	public List<User> getAllUsers() {
		return userDao.getAll();
	}
	
	// get users by Id
	public List<User> getUserById (int userId) {
		
		List<User> users = userDao.getById(userId);
		
		if (users != null) 
			return users;
		
		return null;
	}
	
	// add new user
	public User addUser(User newUser) {

		if (newUser.getUsername().equals("") || 
				newUser.getPassword().equals("") || 
				newUser.getFirst_name().equals("") || 
				newUser.getLast_name().equals("") ||
				newUser.getEmail().equals("")) {
			return null;
		}
		
		return userDao.add(newUser);
	}
	
	// update user that is passed in
	public User updateUser(User updatedUser) {
		
		if (updatedUser.getUsername().equals("") || 
				updatedUser.getPassword().equals("") || 
				updatedUser.getFirst_name().equals("") || 
				updatedUser.getLast_name().equals("") ||
				updatedUser.getEmail().equals(""))
			return null;
		
		return userDao.update(updatedUser);
	}
	
	public boolean deleteUser (int userId) {	
		return false;
	}
	
	// get user by username and password
	public List<User> getUserByCredentials(String username, String password) {
		
		if (username.equals("") || password.equals("")) 
			return null;
		
		return userDao.getByCredentials(username, password);
	}
	
	// get user by username
	public List<User> getUserByUsername(String username) {
		
		if (username.equals("")) 
			return null;
		
		return userDao.getByUsername(username);
	}
}
