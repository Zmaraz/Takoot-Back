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
		
		System.out.println("inside of getAllUsers() in UserService");
		return userDao.getAll();
		
	}
	
	
	// get users by Id
	public List<User> getUserById (int userId) {
		
		System.out.println("inside of getUserById() in UserService");
		if (userDao.getById(userId) != null) 
			return userDao.getById(userId);
		
		return null;
		
	}
	
	
	// add new user
	public User addUser(User newUser) {
		
		System.out.println("inside of addUser() in UserService");
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
	
		
	// update user that is passed in
	public User updateUser(User updatedUser) {
		
		System.out.println("inside of updateUser() in UserService");
		if (updatedUser.getUsername().equals("") || 
				updatedUser.getPassword().equals("") || 
				updatedUser.getFirst_name().equals("") || 
				updatedUser.getLast_name().equals("") ||
				updatedUser.getEmail().equals(""))
			return null;
		
		return userDao.update(updatedUser);
	}
	
	
	// delete user thats passed in
	public boolean deleteUser (int userId) {
		
		System.out.println("inside of deleteUser() in UserService");
		if (userDao.getById(userId) != null)
			return userDao.delete(userId);
		
		return false;
		
	}
	
	
	// get user by username and password
	public List<User> getUserByCredentials(String username, String password) {
		
		System.out.println("inside of getUserByCredentials() in UserService");
		if (username.equals("") || password.equals("")) 
			return null;
		
		return userDao.getByCredentials(username, password);
		
	}
	
	
	// get user by username
	public List<User> getUserByUsername(String username) {
		
		System.out.println("inside of getUserByUsername() in UserService");
		if (username.equals("")) 
			return null;
		
		return userDao.getByUsername(username);
		
	}
	
}
